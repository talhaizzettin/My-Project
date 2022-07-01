package com.example.alifbee.ui.main


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alifbee.databinding.ActivityMainBinding
import android.os.Handler
import android.view.View
import com.example.alifbee.ui.home.HomeActivity
import com.example.alifbee.ui.main.mvc.MainViewImpl
import com.example.alifbee.ui.main.mvc.MainViewMvc


class MainActivity : AppCompatActivity(), MainViewMvc.Listener{


    lateinit var mainViewMvc : MainViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewMvc = MainViewImpl(layoutInflater,null)
        mainViewMvc.registerListener(this)
        hideSystemBars()
        setContentView(mainViewMvc.getRootView())

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    private fun hideSystemBars() {
        //val windowInsetsController =
        // ViewCompat.getWindowInsetsController(window.decorView) ?: return
        //windowInsetsController.systemBarsBehavior =
        // WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        //windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        actionBar?.hide()
    }
}