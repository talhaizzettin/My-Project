package com.example.alifbee.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

class MyTextView(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {
    private var movedOutSide = true

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                movedOutSide = false
                animate().apply {
                    duration = 100
                    scaleX(0.9f)
                    scaleY(0.9f)
                }.start()
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                movedOutSide = true
                animate().apply {
                    duration = 100
                    scaleX(1f)
                    scaleY(1f)
                }.start()
            }
            MotionEvent.ACTION_MOVE -> {
                val rect = Rect(left, top, right, bottom)
                if (!rect.contains(
                        left + event.x.toInt(),
                        top + event.y.toInt()
                    ) && !movedOutSide
                ) {
                    movedOutSide = true
                    animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                }
            }
        }
        return super.onTouchEvent(event)
    }

}