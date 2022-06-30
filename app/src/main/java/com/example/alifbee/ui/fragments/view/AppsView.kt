package com.example.alifbee.ui.fragments.view

import android.content.Context
import android.view.View

interface AppsView {
    interface Listener {

    }
    fun setupRV()
    fun getRootView(): View
    fun getContext(): Context
    fun <T : View> findViewById(id: Int): T
}