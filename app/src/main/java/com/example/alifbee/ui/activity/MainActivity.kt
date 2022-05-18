package com.example.alifbee.ui.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alifbee.databinding.ActivityMainBinding
import android.os.Handler
import android.view.View


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        hideSystemBars()
        setContentView(binding.root)
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