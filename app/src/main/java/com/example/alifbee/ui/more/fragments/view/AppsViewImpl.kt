package com.example.alifbee.ui.more.fragments.view

import android.annotation.SuppressLint
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alifbee.databinding.FragmentAppsBinding
import com.example.alifbee.model.TheApps
import com.example.alifbee.ui.common.BaseObservableViewMvc
import com.example.alifbee.ui.more.adapters.Apps2Adapter

@SuppressLint("ClickableViewAccessibility", "NotifyDataSetChanged")
class AppsViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : BaseObservableViewMvc<AppsView.Listener>(), AppsView {

    private var _binding: FragmentAppsBinding? = null
    private val binding get() = _binding!!

    private lateinit var apps2Adapter: Apps2Adapter

    init {
        _binding = FragmentAppsBinding.inflate(inflater, parent, false)
        setRootView(binding.root)
        binding.porBar.isVisible = true
        setupRV()


        binding.morebackbut.setOnTouchListener { v, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.animate().apply {
                        duration = 100
                        scaleX(0.8f)
                        scaleY(0.8f)
                    }.start()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.animate().apply {
                        duration = 100
                        scaleX(1f)
                        scaleY(1f)
                    }.start()
                }
                MotionEvent.ACTION_MOVE -> {
                    val rect = Rect(v.left, v.top, v.right, v.bottom)
                    if (!rect.contains(
                            v.left + motionEvent.x.toInt(),
                            v.top + motionEvent.y.toInt()
                        )
                    ) {
                        v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                    }
                }
            }
            false
        }

        binding.morebackbut.setOnClickListener {
            for (listener in listeners) {
                listener.onBackPressed()
            }

        }
    }


    override fun setupRV() {
        apps2Adapter = Apps2Adapter()
        binding.rvapps.apply {
            adapter = apps2Adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun setAppsData(apps: List<TheApps>) {
        apps2Adapter.apps = apps
        apps2Adapter.notifyDataSetChanged()
        binding.porBar.isVisible = false
    }

    override fun destroyView() {
        _binding = null
    }
}