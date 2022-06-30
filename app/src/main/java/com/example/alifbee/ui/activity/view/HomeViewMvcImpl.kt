package com.example.alifbee.ui.activity.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.alifbee.R
import com.example.alifbee.databinding.ActivityHomeBinding
import com.example.alifbee.ui.Constants
import com.example.alifbee.ui.activity.MoreActivity
import com.example.alifbee.ui.adapters.ImgSlidAdapter


@SuppressLint("ClickableViewAccessibility")
class HomeViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    supportFragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : HomeViewMvc {



    private lateinit var listener: HomeViewMvc.Listener
    private var movedOutSide = true
    private val binding = ActivityHomeBinding.inflate(inflater, parent, false)

    fun morByUs(listener: HomeViewMvc.Listener) {
        this.listener = listener
    }
    init {
        var music = true
        binding.musicImg.setOnClickListener {
            music = if (music) {
                binding.musicImg.setImageResource(R.drawable.off)
                false
            } else {
                binding.musicImg.setImageResource(R.drawable.on)
                true
            }
        }

        binding.backimgbut.visibility = View.INVISIBLE
        val adapter = ImgSlidAdapter(supportFragmentManager, lifecycle)



        binding.imgslider.adapter = adapter
        binding.imgslider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.nextimgbut.visibility = View.VISIBLE
                binding.backimgbut.visibility = View.VISIBLE
                if (binding.imgslider.currentItem == 3 - 1) {
                    binding.nextimgbut.visibility = View.INVISIBLE
                }
                if (binding.imgslider.currentItem == 0) {
                    binding.backimgbut.visibility = View.INVISIBLE
                }

            }
        })
        binding.nextimgbut.setOnTouchListener { vi, motionEvent ->
            setOnTouchListener(vi, motionEvent)
        }

        binding.backimgbut.setOnTouchListener { vi, motionEvent ->
            setOnTouchListener(vi, motionEvent)
        }

        binding.nextimgbut.setOnClickListener {
            chek(Constants.NEXT_PAGE)
        }

        binding.backimgbut.setOnClickListener {
            chek(Constants.PREV_PAGE)
        }
        binding.moreTV.setOnClickListener {
            val intent = Intent(getContext(), MoreActivity::class.java)
            listener.onMoreByUsClicked(intent)
        }

    }

    override fun <T : View> findViewById(id: Int): T {
        return getRootView().findViewById(id)
    }

    override fun getContext(): Context {
        return getRootView().context
    }

    override fun getRootView(): View {
        return binding.root
    }

    override fun setOnTouchListener(v: View, event: MotionEvent): Boolean {
        Log.e("Touch", "event: ${event.action}")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                movedOutSide = false
                v.animate().apply {
                    duration = 100
                    scaleX(0.5f)
                    scaleY(0.5f)
                }.start()
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                movedOutSide = true
                v.animate().apply {
                    duration = 100
                    scaleX(1f)
                    scaleY(1f)
                }.start()
            }

            MotionEvent.ACTION_MOVE -> {
                val rect = Rect(v.left, v.top, v.right, v.bottom)
                if (!rect.contains(
                        v.left + event.x.toInt(),
                        v.top + event.y.toInt()
                    ) && !movedOutSide
                ) {
                    movedOutSide = true
                    v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                }
            }
        }
        return false
    }

    override fun chek(way: Int) {
        when (way) {
            Constants.NEXT_PAGE -> {
                binding.imgslider.currentItem++
            }
            Constants.PREV_PAGE -> {
                binding.imgslider.currentItem--
            }
        }
    }


}