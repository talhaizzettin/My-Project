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
    }
}

