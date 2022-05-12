package com.example.alifbee.ui.fragments


import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.alifbee.R
import com.example.alifbee.databinding.FragmentImgSlidBinding
import com.example.alifbee.model.ImgSlidAdapter
import com.example.alifbee.ui.Constants.NEXT_PAGE
import com.example.alifbee.ui.Constants.PREV_PAGE
import kotlinx.android.synthetic.main.fragment_img_slid.*
import kotlinx.android.synthetic.main.fragment_img_slid.view.*




class ImgSlidFrag : Fragment() {
    private lateinit var binding : FragmentImgSlidBinding
    var movedOutSide = true

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_img_slid, container, false)


        view.backimgbut.visibility = View.INVISIBLE

        val adapter =  ImgSlidAdapter(requireActivity().supportFragmentManager, lifecycle)
        view.imgslider.adapter = adapter
//        val backImg : ImageView = view.findViewById(R.id.n)/

        view.nextimgbut.setOnTouchListener { vi, motionEvent ->
             setOnTouchListener(vi, motionEvent)
        }

        view.backimgbut.setOnTouchListener { vi, motionEvent ->
            setOnTouchListener(vi, motionEvent)
        }

        view.nextimgbut.setOnClickListener{ v ->
            chek(view,NEXT_PAGE)
        }

        view.backimgbut.setOnClickListener{
            chek(view, PREV_PAGE)
        }

        view.imgslider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                view.nextimgbut.visibility = View.VISIBLE
                view.backimgbut.visibility = View.VISIBLE
                if(view.imgslider.currentItem == 3-1){
                    view.nextimgbut.visibility = View.INVISIBLE
                }
                if(view.imgslider.currentItem == 0){
                    view.backimgbut.visibility = View.INVISIBLE
                }

            }
        })




        return view
    }
    private fun chek (view:View,way:Int){
        when(way){
            NEXT_PAGE ->{
                view.imgslider.currentItem++
            }
            PREV_PAGE ->{
                view.imgslider.currentItem--
            }
        }
    }

    private fun setOnTouchListener(v : View , event : MotionEvent) : Boolean {
        Log.e("Touch","event: ${event.action}")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                movedOutSide = false
                v.animate().apply {
                    duration = 100
                    scaleX(0.5f)
                    scaleY(0.5f)
                }.start()                }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                movedOutSide = true
                v.animate().apply {
                    duration = 100
                    scaleX(1f)
                    scaleY(1f)
                }.start()                }

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
}