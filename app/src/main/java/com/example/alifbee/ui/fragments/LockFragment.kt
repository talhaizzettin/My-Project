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

        binding.bu0.setOnClickListener {
            theNum = 0
            myCheck()
        }
        binding.bu1.setOnClickListener {
            theNum = 1
            myCheck()
        }
        binding.bu2.setOnClickListener {
            theNum = 2
            myCheck()
        }
        binding.bu3.setOnClickListener {
            theNum = 3
            myCheck()
        }
        binding.bu4.setOnClickListener {
            theNum = 4
            myCheck()
        }
        binding.bu5.setOnClickListener {
            theNum = 5
            myCheck()
        }
        binding.bu6.setOnClickListener {
            theNum = 6
            myCheck()
        }
        binding.bu7.setOnClickListener {
            theNum = 7
            myCheck()
        }
        binding.bu8.setOnClickListener {
            theNum = 8
            myCheck()
        }
        binding.bu9.setOnClickListener {
            theNum = 9
            myCheck()
        }
        binding.bude.setOnClickListener {
            del()
        }

        binding.bude.setOnTouchListener(touchListener)

    }

    @SuppressLint("SetTextI18n")
    fun randomNum() {
        val myNumberList = HashMap<Int, String>()
        myNumberList[0] = "Zero"
        myNumberList[1] = "One"
        myNumberList[2] = "Two"
        myNumberList[3] = "Three"
        myNumberList[4] = "Four"
        myNumberList[5] = "Five"
        myNumberList[6] = "Six"
        myNumberList[7] = "Seven"
        myNumberList[8] = "Eight"
        myNumberList[9] = "Nine"
        binding.textnum.text =
            myNumberList[numb1] + ", " + myNumberList[numb2] + ", " + myNumberList[numb3]
    }

    private fun del() {
        when (index) {
            1 -> {
                binding.num1.text = ""
                index--
            }
            2 -> {
                binding.num2.text = ""
                index--
            }
            3 -> {
                binding.num3.text = ""
                index--
            }
        }
    }

    private fun myCheck() {
        when (index) {
            0 -> {
                binding.num1.text = theNum.toString()
                firstNum = theNum
                index++
            }
            1 -> {
                binding.num2.text = theNum.toString()
                secondNum = theNum
                index++
            }
            2 -> {
                index++
                binding.num3.text = theNum.toString()
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