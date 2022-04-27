package com.example.alifbee.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.alifbee.databinding.ActivityMainBinding
import android.os.Handler
import android.view.View

private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        hideSystemBars()
        setContentView(binding.root)
        Handler().postDelayed({
            val intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
            finish()
        },2000)




    }
    private fun hideSystemBars() {
        //val windowInsetsController =
           // ViewCompat.getWindowInsetsController(window.decorView) ?: return

        //windowInsetsController.systemBarsBehavior =
           // WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        //windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        actionBar?.hide()
    }
}