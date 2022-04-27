package com.example.alifbee.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.alifbee.R
import com.example.alifbee.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.fragment_img_slid.view.*

private lateinit var binding: ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        hideSystemBars()

       // imf.setOnClickListener(View.OnClickListener { imf.setImageDrawable(getDrawable(R.drawable.off)) })
        setContentView(binding.root)
        var more = binding.morebu
        var mus = binding.musicImg

        var musi = true

        more.setOnClickListener{
            val intent = Intent(this@HomeActivity,ParentsLock::class.java)
            startActivity(intent)
            finish()
        }
        mus.setOnClickListener{
            if(musi == true){
                mus.setImageResource(R.drawable.off)
                musi=false
            }
            else{
                mus.setImageResource(R.drawable.on)
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