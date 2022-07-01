package com.example.alifbee.ui.more.fragments.view

import android.annotation.SuppressLint
import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alifbee.api.Retr
import com.example.alifbee.databinding.FragmentAppsBinding
import com.example.alifbee.model.AppsRes
import com.example.alifbee.ui.common.BaseObservableViewMvc
import com.example.alifbee.ui.more.adapters.Apps2Adapter
import retrofit2.HttpException
import java.io.IOException
import java.util.*

@SuppressLint("ClickableViewAccessibility", "NotifyDataSetChanged")
class AppsViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    lifecycleScope: LifecycleCoroutineScope
) : BaseObservableViewMvc<AppsView.Listener>(), AppsView {

    private var _binding: FragmentAppsBinding? = null
    private val binding get() = _binding!!

    private lateinit var apps2Adapter: Apps2Adapter

    init {
        _binding = FragmentAppsBinding.inflate(inflater, parent, false)
        setRootView(binding.root)
        setupRV()
        setApi(lifecycleScope)


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
            for (listener in listeners){
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

    override fun setApi(lifecycleScope: LifecycleCoroutineScope) {
        lifecycleScope.launchWhenCreated {
            binding.porBar.isVisible = true
            val jsonApps = try {
                Retr.api.getApps()
            } catch (e: IOException) {
                Log.e("Error", "INT no")
                binding.porBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e("Error", "HttpException no")
                binding.porBar.isVisible = false
                return@launchWhenCreated
            }
            if (jsonApps.isSuccessful && jsonApps.body() != null) {
                val theApps: AppsRes = jsonApps.body()!!
                if (Locale.getDefault().language == Locale("ar").language)
                    apps2Adapter.apps = theApps.body.our_apps.ar
                else {
                    apps2Adapter.apps = theApps.body.our_apps.en
                }
                apps2Adapter.notifyDataSetChanged()
            } else {
                Log.e("body", "${jsonApps.body()}")
                Log.e("isSuccessful", "${jsonApps.isSuccessful}")
            }
            binding.porBar.isVisible = false
        }
    }

    override fun destroyView() {
        _binding = null
    }
}