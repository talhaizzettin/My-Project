package com.example.alifbee.ui.activity

import android.annotation.SuppressLint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.example.alifbee.databinding.ActivityMoreBinding

class MoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoreBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var movedOutSide = true

        binding.morebackbut.setOnTouchListener { v, motionEvent ->
            when (motionEvent.action) {
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
                            v.left + motionEvent.x.toInt(),
                            v.top + motionEvent.y.toInt()
                        ) && !movedOutSide
                    ) {
                        movedOutSide = true
                        v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                    }
                }
            }
            false
        }

        binding.morebackbut.setOnClickListener {
            onBackPressed()
            finish()
        }

    }
}

