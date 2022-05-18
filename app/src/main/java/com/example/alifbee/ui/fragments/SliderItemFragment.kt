package com.example.alifbee.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alifbee.R
import com.example.alifbee.databinding.FragmentSliderImgsBinding


class SliderItemFragment : Fragment() {
    private var position: Int = 0

    private var _binding: FragmentSliderImgsBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ARG_PARAM1, 0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSliderImgsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView()?.apply {
            when (position) {
                0 -> binding.gameImg.setImageResource(R.drawable.game)
                1 -> binding.gameImg.setImageResource(R.drawable.video)
                2 -> binding.gameImg.setImageResource(R.drawable.music)
            }
        }
    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(pos: Int) =
            SliderItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, pos)
                }
            }
    }
}