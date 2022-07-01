package com.example.alifbee.ui.more

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alifbee.databinding.ActivityMoreBinding
import com.example.alifbee.ui.more.mvc.MoreViewImpl
import com.example.alifbee.ui.more.mvc.MoreViewMvc

class MoreActivity :MoreViewMvc.Listener, AppCompatActivity() {

    private lateinit var mViewMcv : MoreViewMvc
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewMcv = MoreViewImpl(layoutInflater, null)
        setContentView(mViewMcv.getRootView())
    }
}

