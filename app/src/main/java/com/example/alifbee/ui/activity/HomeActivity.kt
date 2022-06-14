package com.example.alifbee.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class HomeActivity : AppCompatActivity() {

    lateinit var hViewMcv : HomeViewMvc


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        hViewMcv= HomeViewMvc(layoutInflater,null,supportFragmentManager,lifecycle)
        hideSystemBars()

        setContentView(hViewMcv.getRootView())




    }
    private fun hideSystemBars() {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            actionBar?.hide()

    }
}