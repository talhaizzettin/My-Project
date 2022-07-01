package com.example.alifbee.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.alifbee.ui.home.mvc.HomeViewMvc
import com.example.alifbee.ui.home.mvc.HomeViewMvcImpl


class HomeActivity : AppCompatActivity(), HomeViewMvc.Listener {

     private lateinit var hViewMcv: HomeViewMvc

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hViewMcv = HomeViewMvcImpl(layoutInflater, null, supportFragmentManager, lifecycle)
        hViewMcv.registerListener(this)
        hideSystemBars()
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