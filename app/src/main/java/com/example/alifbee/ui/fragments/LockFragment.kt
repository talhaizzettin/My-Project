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
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.alifbee.R
import kotlinx.android.synthetic.main.fragment_lock.view.*
import kotlin.random.Random
import kotlinx.android.synthetic.main.fragment_lock.*

class LockFragment : Fragment() {


    var numb1 = Random.nextInt(10)
    var numb2= Random.nextInt(10)
    var numb3= Random.nextInt(10)
    var index :Int=0
    var theNum :Int=0
    var firstNum:Int=0
    var secondNum:Int=0
    var thirdNum:Int=0

    lateinit var textnum : TextView
    lateinit var num1 : TextView
    lateinit var num2 : TextView
    lateinit var num3 : TextView
    var movedOutSide = true



    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_lock,container,false)
        textnum = view.findViewById(R.id.textnum)
        num1 = view.findViewById(R.id.num1)
        num2 = view.findViewById(R.id.num2)
        num3 = view.findViewById(R.id.num3)

        randomgen ()

        view.bu0.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu0.setOnClickListener(){
            theNum=0
            myCheck()
        }

        view.bu1.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu1.setOnClickListener(){
            theNum=1
            myCheck()
        }

        view.bu2.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu2.setOnClickListener(){
            theNum=2
            myCheck()
        }

        view.bu3.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu3.setOnClickListener(){
            theNum=3
            myCheck()
        }

        view.bu4.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu4.setOnClickListener(){
            theNum=4
            myCheck()
        }

        view.bu5.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu5.setOnClickListener(){
            theNum=5
            myCheck()
        }

        view.bu6.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu6.setOnClickListener(){
            theNum=6
            myCheck()
        }

        view.bu7.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu7.setOnClickListener(){
            theNum=7
            myCheck()
        }

        view.bu8.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu8.setOnClickListener(){
            theNum=8
            myCheck()
        }

        view.bu9.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bu9.setOnClickListener(){
            theNum=9
            myCheck()
        }

        view.bude.setOnTouchListener { vi, motionEvent ->
            ani(vi, motionEvent)
        }
        view.bude.setOnClickListener(){
            del()
        }
        return view
    }

    @SuppressLint("SetTextI18n")
    fun randomgen (){
        val myNumberList = HashMap<Int,String>()
        myNumberList.put(0,"Zero")
        myNumberList.put(1,"One")
        myNumberList.put(2,"Two")
        myNumberList.put(3,"Three")
        myNumberList.put(4,"Four")
        myNumberList.put(5,"Five")
        myNumberList.put(6,"Six")
        myNumberList.put(7,"Seven")
        myNumberList.put(8,"Eight")
        myNumberList.put(9,"Nine")
        textnum.text = myNumberList[numb1]+", "+myNumberList[numb2]+", "+myNumberList[numb3]
        //binding.textnum.text = myNumberList[numb1]+","+myNumberList[numb2]+","+myNumberList[numb3]
    }

    fun del(){
        when(index){
            1->{
                num1.text = ""
                index--
            }
            2->{
                num2.text = ""
                index--
            }
            3->{
                num3.text = ""
                index--
            }
        }
    }
    fun myCheck(){
        when(index){
            0->{
                num1.text = theNum.toString()
                firstNum=theNum
                index++
            }
            1->{
                num2.text = theNum.toString()
                secondNum=theNum
                index++
            }
            2->{
                index++
                num3.text = theNum.toString()
                thirdNum=theNum
                if(numb1==firstNum && numb2==secondNum && numb3 == thirdNum){
                    findNavController().navigate(R.id.action_lockFragment_to_moreFragment)
                }else{

                }
            }
        }

    }

    private fun ani(v : View , event : MotionEvent) : Boolean {
        Log.e("Touch","event: ${event.action}")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                movedOutSide = false
                v.animate().apply {
                    duration = 100
                    scaleX(0.8f)
                    scaleY(0.8f)
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