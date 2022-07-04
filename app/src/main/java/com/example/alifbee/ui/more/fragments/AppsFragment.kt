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
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alifbee.api.Retr
import com.example.alifbee.databinding.FragmentAppsBinding
import com.example.alifbee.model.AppsRes
import com.example.alifbee.ui.more.adapters.Apps2Adapter
import com.example.alifbee.ui.more.fragments.view.AppsView
import com.example.alifbee.ui.more.fragments.view.AppsViewImpl
import com.example.alifbee.ui.more.fragments.viewModel.AppsViewModel
import retrofit2.HttpException
import java.io.IOException
import java.util.*


class AppsFragment : Fragment(), AppsView.Listener {
    private val aViewModel :AppsViewModel by viewModels()
    lateinit var aViewMvc: AppsView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        aViewMvc = AppsViewImpl(inflater, container)
        aViewMvc.registerListener(this)
        return aViewMvc.getRootView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        aViewModel.ourApps.observe(viewLifecycleOwner){
            aViewMvc.setAppsData(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        aViewMvc.destroyView()
    }

    override fun onBackPressed() {
        requireActivity().onBackPressed()
    }
}