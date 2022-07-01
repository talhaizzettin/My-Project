package com.example.alifbee.ui.more.fragments

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alifbee.api.Retr
import com.example.alifbee.databinding.FragmentAppsBinding
import com.example.alifbee.model.AppsRes
import com.example.alifbee.ui.more.adapters.Apps2Adapter
import com.example.alifbee.ui.more.fragments.view.AppsView
import com.example.alifbee.ui.more.fragments.view.AppsViewImpl
import retrofit2.HttpException
import java.io.IOException
import java.util.*


class AppsFragment : Fragment(), AppsView.Listener {

    lateinit var aViewMvc: AppsView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        aViewMvc = AppsViewImpl(inflater, container, lifecycleScope)
        aViewMvc.registerListener(this)
        return aViewMvc.getRootView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        aViewMvc.destroyView()
    }

    override fun onBackPressed() {
        requireActivity().onBackPressed()
    }
}