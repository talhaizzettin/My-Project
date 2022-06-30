package com.example.alifbee.ui.fragments.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alifbee.databinding.FragmentAppsBinding

class AppsViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : AppsView {

    private var _binding: FragmentAppsBinding? = null
    private val binding get() = _binding!!

    init {
        _binding = FragmentAppsBinding.inflate(inflater, parent, false)
        setupRV()
    }

    override fun <T : View> findViewById(id: Int): T {
        return getRootView().findViewById(id)
    }

    override fun getContext(): Context {
        return getRootView().context
    }

    override fun setupRV() {
        TODO("Not yet implemented")
    }

    override fun getRootView(): View {
        return binding.root
    }
}