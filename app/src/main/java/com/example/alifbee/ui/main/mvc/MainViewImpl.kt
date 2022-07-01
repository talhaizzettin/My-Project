package com.example.alifbee.ui.main.mvc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alifbee.databinding.ActivityMainBinding
import com.example.alifbee.ui.common.BaseObservableViewMvc

class MainViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : BaseObservableViewMvc<MainViewMvc.Listener>(),MainViewMvc {

    private var binding: ActivityMainBinding

    init {
        binding = ActivityMainBinding.inflate(inflater,parent,false)
        setRootView(binding.root)
    }

}