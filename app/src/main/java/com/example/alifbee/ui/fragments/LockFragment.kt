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
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.alifbee.R
import com.example.alifbee.databinding.FragmentLockBinding
import com.example.alifbee.ui.activity.MoreActivity
import com.example.alifbee.ui.utils.touchListener
import kotlin.random.Random

class LockFragment : Fragment() {

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


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLockBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        randomNum()

        binding.include.bu0.setOnClickListener {
            theNum = 0
            myCheck()
        }
        binding.include.bu1.setOnClickListener {
            theNum = 1
            myCheck()
        }
        binding.include.bu2.setOnClickListener {
            theNum = 2
            myCheck()
        }
        binding.include.bu3.setOnClickListener {
            theNum = 3
            myCheck()
        }
        binding.include.bu4.setOnClickListener {
            theNum = 4
            myCheck()
        }
        binding.include.bu5.setOnClickListener {
            theNum = 5
            myCheck()
        }
        binding.include.bu6.setOnClickListener {
            theNum = 6
            myCheck()
        }
        binding.include.bu7.setOnClickListener {
            theNum = 7
            myCheck()
        }
        binding.include.bu8.setOnClickListener {
            theNum = 8
            myCheck()
        }
        binding.include.bu9.setOnClickListener {
            theNum = 9
            myCheck()
        }
        binding.include.bude.setOnClickListener {
            del()
        }

        //binding.bude.setOnTouchListener(touchListener)

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
            activity?.onBackPressed()
        }

    }

    @SuppressLint("SetTextI18n")
    fun randomNum() {
        val myNumberList = HashMap<Int, String>()
        myNumberList[0] = getString(R.string.zero)
        myNumberList[1] = getString(R.string.one)
        myNumberList[2] = getString(R.string.two)
        myNumberList[3] = getString(R.string.three)
        myNumberList[4] = getString(R.string.four)
        myNumberList[5] = getString(R.string.five)
        myNumberList[6] = getString(R.string.six)
        myNumberList[7] = getString(R.string.seven)
        myNumberList[8] = getString(R.string.eight)
        myNumberList[9] = getString(R.string.nine)
        binding.textnum.text =
            myNumberList[numb1] + ", " + myNumberList[numb2] + ", " + myNumberList[numb3]
    }

    private fun del() {
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

    private fun myCheck() {
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
                    findNavController().navigate(R.id.action_lockFragment_to_moreFragment)

                } else {
                    Toast.makeText(context, "Try Agn", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}