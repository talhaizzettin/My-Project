package com.example.alifbee.ui.more.fragments.view

import android.content.Context
import android.view.View
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.alifbee.model.TheApps
import com.example.alifbee.ui.common.ObservableViewMvc
import com.example.alifbee.ui.common.ViewMvc

interface AppsView : ObservableViewMvc<AppsView.Listener> {
    interface Listener {
        fun onBackPressed()
    }
    fun setupRV()
    fun setAppsData(apps: List<TheApps>)
    fun destroyView()
}