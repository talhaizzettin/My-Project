package com.example.alifbee.ui.more.fragments.view

import com.example.alifbee.ui.common.ObservableViewMvc
import com.example.alifbee.ui.common.ViewMvc

interface LockViewMvc : ObservableViewMvc<LockViewMvc.Listener> {
    interface Listener {
        fun nextFragment()
        fun onBackPressed()
    }
    fun randomNum()
    fun del()
    fun myCheck()
    fun onClick(number : Int)
    fun destroyView()
}