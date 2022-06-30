package com.example.alifbee.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.alifbee.ui.activity.view.HomeViewMvc
import com.example.alifbee.ui.activity.view.HomeViewMvcImpl


class HomeActivity : AppCompatActivity(), HomeViewMvc.Listener {

     private lateinit var hViewMcv: HomeViewMvcImpl

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hViewMcv = HomeViewMvcImpl(layoutInflater, null, supportFragmentManager, lifecycle)
        hideSystemBars()
        hViewMcv.morByUs(this)
        setContentView(hViewMcv.getRootView())
    }

    private fun hideSystemBars() {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        actionBar?.hide()

    }

    override fun onMoreByUsClicked(intent: Intent) {
        startActivity(intent)
    }
}