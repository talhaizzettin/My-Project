package com.example.alifbee.ui.common

import android.content.Context
import android.view.View

abstract class BaseViewMvc : ViewMvc {

    private lateinit var mRootView : View
    override fun getRootView(): View {
        return mRootView
    }

    protected fun setRootView(view: View) {
        mRootView = view
    }

    protected open fun <T : View?> findViewById(id: Int): T {
        return getRootView().findViewById(id)
    }

    protected fun getContext(): Context = getRootView().context
}