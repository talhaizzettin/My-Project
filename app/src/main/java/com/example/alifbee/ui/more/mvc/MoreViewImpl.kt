package com.example.alifbee.ui.more.mvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.alifbee.databinding.ActivityMoreBinding
import com.example.alifbee.ui.common.BaseObservableViewMvc

class MoreViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) :BaseObservableViewMvc<MoreViewMvc.Listener>(), MoreViewMvc {
    private var binding : ActivityMoreBinding
    init {
        binding = ActivityMoreBinding.inflate(inflater,parent,false)
        setRootView(binding.root)
    }
}