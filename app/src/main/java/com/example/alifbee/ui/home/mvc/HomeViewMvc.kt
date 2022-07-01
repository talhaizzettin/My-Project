package com.example.alifbee.ui.home.mvc

import android.content.Context
import android.content.Intent
import android.view.MotionEvent
import android.view.View
import com.example.alifbee.ui.common.ObservableViewMvc
import com.example.alifbee.ui.common.ViewMvc

interface HomeViewMvc : ObservableViewMvc<HomeViewMvc.Listener> {

    interface Listener {
        fun onMoreByUsClicked(intent: Intent)
    }

    fun setOnTouchListener(v: View, event: MotionEvent): Boolean
    fun chek(way: Int)
}