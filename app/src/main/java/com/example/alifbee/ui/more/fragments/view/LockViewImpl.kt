package com.example.alifbee.ui.more.fragments.view

import android.annotation.SuppressLint
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.Toast
import com.example.alifbee.R
import com.example.alifbee.databinding.FragmentLockBinding
import com.example.alifbee.ui.common.BaseObservableViewMvc
import kotlin.random.Random

@SuppressLint("ClickableViewAccessibility")
class LockViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) :BaseObservableViewMvc<LockViewMvc.Listener>(),LockViewMvc {
    private var _binding: FragmentLockBinding? = null
    private val binding get() = _binding!!

    private var numb1 = Random.nextInt(10)
    private var numb2 = Random.nextInt(10)
    private var numb3 = Random.nextInt(10)
    private var index: Int = 0
    private var theNum: Int = 0
    private var firstNum: Int = 0
    private var secondNum: Int = 0
    private var thirdNum: Int = 0

    init {
        _binding = FragmentLockBinding.inflate(inflater,parent,false)
        setRootView(binding.root)
        randomNum()

        binding.include.bu0.setOnClickListener {
            onClick(0)
        }
        binding.include.bu1.setOnClickListener {
            onClick(1)
        }
        binding.include.bu2.setOnClickListener {
            onClick(2)
        }
        binding.include.bu3.setOnClickListener {
            onClick(3)
        }
        binding.include.bu4.setOnClickListener {
            onClick(4)
        }
        binding.include.bu5.setOnClickListener {
            onClick(5)
        }
        binding.include.bu6.setOnClickListener {
            onClick(6)
        }
        binding.include.bu7.setOnClickListener {
            onClick(7)
        }
        binding.include.bu8.setOnClickListener {
            onClick(8)
        }
        binding.include.bu9.setOnClickListener {
            onClick(9)
        }
        binding.include.bude.setOnClickListener {
            del()
        }
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

    @SuppressLint("SetTextI18n")
    override fun randomNum() {
        val myNumberList = HashMap<Int, String>()
        myNumberList[0] = getContext().getString(R.string.zero)
        myNumberList[1] = getContext().getString(R.string.one)
        myNumberList[2] = getContext().getString(R.string.two)
        myNumberList[3] = getContext().getString(R.string.three)
        myNumberList[4] = getContext().getString(R.string.four)
        myNumberList[5] = getContext().getString(R.string.five)
        myNumberList[6] = getContext().getString(R.string.six)
        myNumberList[7] = getContext().getString(R.string.seven)
        myNumberList[8] = getContext().getString(R.string.eight)
        myNumberList[9] = getContext().getString(R.string.nine)

        binding.textnum.text =
            myNumberList[numb1] + ", " + myNumberList[numb2] + ", " + myNumberList[numb3]
    }

    override fun del() {
        when (index) {
            1 -> {
                binding.include.num1.text = ""
                index--
            }
            2 -> {
                binding.include.num2.text = ""
                index--
            }
            3 -> {
                binding.include.num3.text = ""
                index--
            }
        }
    }

    override fun myCheck() {
        when (index) {
            0 -> {
                binding.include.num1.text = theNum.toString()
                firstNum = theNum
                index++
            }
            1 -> {
                binding.include.num2.text = theNum.toString()
                secondNum = theNum
                index++
            }
            2 -> {
                index++
                binding.include.num3.text = theNum.toString()
                thirdNum = theNum
                if (numb1 == firstNum && numb2 == secondNum && numb3 == thirdNum) {
                    for (listener in listeners){
                        listener.nextFragment()
                    }
                } else {
                    Toast.makeText(getContext(), "Try Agn", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onClick(number: Int) {
        theNum = number
        myCheck()
    }

    override fun destroyView() {
        _binding = null
    }
}