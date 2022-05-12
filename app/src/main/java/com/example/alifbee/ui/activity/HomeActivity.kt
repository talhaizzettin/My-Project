package com.example.alifbee.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.example.alifbee.R
import com.example.alifbee.databinding.ActivityHomeBinding




class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        hideSystemBars()

       // imf.setOnClickListener(View.OnClickListener { imf.setImageDrawable(getDrawable(R.drawable.off)) })
        setContentView(binding.root)
        var movedOutSide = true

        var musi = true

        binding.morebu.setOnTouchListener(){v : View , event : MotionEvent ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    movedOutSide = false
                    v.animate().apply {
                        duration = 100
                        scaleX(0.8f)
                        scaleY(0.8f)
                    }.start()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    movedOutSide = true
                    v.animate().apply {
                        duration = 100
                        scaleX(1f)
                        scaleY(1f)
                    }.start()
                }
                MotionEvent.ACTION_MOVE -> {
                    val rect = Rect(v.left, v.top, v.right, v.bottom)
                    if (!rect.contains(
                            v.left + event.x.toInt(),
                            v.top + event.y.toInt()
                        ) && !movedOutSide
                    ) {
                        movedOutSide = true
                        v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                    }
                }
            }
            false
        }




        binding.morebu.setOnClickListener{
            val intent = Intent(this@HomeActivity, MoreActivity::class.java)
            startActivity(intent)

        }

        binding.musicImg.setOnClickListener{
            if(musi == true){
                binding.musicImg.setImageResource(R.drawable.off)
                musi=false
            }
            else{
                binding.musicImg.setImageResource(R.drawable.on)
                musi=true
            }
        }

    }
    private fun hideSystemBars() {
      //  val windowInsetsController =
           // ViewCompat.getWindowInsetsController(window.decorView) ?: return
       // windowInsetsController.systemBarsBehavior =
           // WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        //windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        actionBar?.hide()

    }
}