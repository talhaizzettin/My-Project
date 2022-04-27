package com.example.alifbee.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
import com.example.alifbee.R
import com.example.alifbee.model.imgs.FirstImg
import com.example.alifbee.model.imgs.SecondImg
import com.example.alifbee.model.imgs.ThirdImg
import com.example.alifbee.databinding.FragmentImgSlidBinding
import kotlinx.android.synthetic.main.fragment_img_slid.view.*


private lateinit var binding : FragmentImgSlidBinding

class ImgSlidFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_img_slid, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstImg(),SecondImg(),ThirdImg()

        )
        view.backimgbut.visibility = View.INVISIBLE







        val adapter = ImgSlidAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)
        view.imgslider.adapter = adapter
        var  sizIs = fragmentList.size

        view.nextimgbut.setOnClickListener{
            chek(view,"Next",sizIs)
        }
        view.backimgbut.setOnClickListener{
            chek(view, "Before",sizIs)
        }
        view.imgslider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                view.nextimgbut.visibility = View.VISIBLE
                view.backimgbut.visibility = View.VISIBLE
                if(view.imgslider.currentItem == sizIs-1){
                    view.nextimgbut.visibility = View.INVISIBLE
                }
                if(view.imgslider.currentItem == 0){
                    view.backimgbut.visibility = View.INVISIBLE
                }

            }
        })




        return view
    }
    private fun chek (view:View,way:String,size : Int){
        when(way){
            "Next"->{
                view.imgslider.currentItem++
                view.backimgbut.visibility = View.VISIBLE

            }
            "Before"->{
                view.imgslider.currentItem--
                view.nextimgbut.visibility = View.VISIBLE

            }
        }
    }
}