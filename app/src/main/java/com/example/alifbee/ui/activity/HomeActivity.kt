package com.example.alifbee.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.alifbee.R
import com.example.alifbee.databinding.ActivityHomeBinding
import com.example.alifbee.ui.Constants
import com.example.alifbee.ui.adapters.ImgSlidAdapter



class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var movedOutSide = true

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        hideSystemBars()

        setContentView(binding.root)


        var music = true


        binding.moreTV.setOnClickListener {
            val intent = Intent(this@HomeActivity, MoreActivity::class.java)
            startActivity(intent)

        }

        binding.musicImg.setOnClickListener {
            music = if (music) {
                binding.musicImg.setImageResource(R.drawable.off)
                false
            } else {
                binding.musicImg.setImageResource(R.drawable.on)
                true
            }
        }
        binding.backimgbut.visibility = View.INVISIBLE

        val adapter = ImgSlidAdapter(supportFragmentManager, lifecycle)

        binding.imgslider.adapter = adapter



        binding.nextimgbut.setOnTouchListener { vi, motionEvent ->
            setOnTouchListener(vi, motionEvent)
        }

        binding.backimgbut.setOnTouchListener { vi, motionEvent ->
            setOnTouchListener(vi, motionEvent)
        }

        binding.nextimgbut.setOnClickListener {
            chek(Constants.NEXT_PAGE)
        }

        binding.backimgbut.setOnClickListener {
            chek(Constants.PREV_PAGE)
        }

        binding.imgslider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.nextimgbut.visibility = View.VISIBLE
                binding.backimgbut.visibility = View.VISIBLE
                if (binding.imgslider.currentItem == 3 - 1) {
                    binding.nextimgbut.visibility = View.INVISIBLE
                }
                if (binding.imgslider.currentItem == 0) {
                    binding.backimgbut.visibility = View.INVISIBLE
                }

            }
        })
    }

    private fun chek(way: Int) {
        when (way) {
            Constants.NEXT_PAGE -> {
                binding.imgslider.currentItem++
            }
            Constants.PREV_PAGE -> {
                binding.imgslider.currentItem--
            }
        }
    }

    private fun setOnTouchListener(v: View, event: MotionEvent): Boolean {
        Log.e("Touch", "event: ${event.action}")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                movedOutSide = false
                v.animate().apply {
                    duration = 100
                    scaleX(0.5f)
                    scaleY(0.5f)
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
        return false
    }

    private fun hideSystemBars() {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            actionBar?.hide()

    }
}