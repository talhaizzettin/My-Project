package com.example.alifbee.ui.utils

import android.annotation.SuppressLint
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View


@SuppressLint("ClickableViewAccessibility")
val touchListener = View.OnTouchListener { v, event ->
    when (event?.action) {
        MotionEvent.ACTION_DOWN -> {
            v.animate().apply {
                duration = 100
                scaleX(0.9f)
                scaleY(0.9f)

            }.start()
        }
        MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
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
                )
            ) {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
            }
        }
    }
    false
}
