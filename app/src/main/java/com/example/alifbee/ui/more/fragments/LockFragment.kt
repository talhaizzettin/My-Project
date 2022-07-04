package com.example.alifbee.ui.more.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alifbee.R
import com.example.alifbee.ui.more.fragments.view.LockViewImpl
import com.example.alifbee.ui.more.fragments.view.LockViewMvc

class LockFragment : Fragment(), LockViewMvc.Listener {

    private lateinit var lViewMvc: LockViewMvc


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lViewMvc = LockViewImpl(inflater, container)
        lViewMvc.registerListener(this)
        return lViewMvc.getRootView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lViewMvc.destroyView()
    }

    override fun nextFragment() {
        findNavController().navigate(R.id.action_lockFragment_to_moreFragment)
    }

    override fun onBackPressed() {
        activity?.onBackPressed()
    }
}