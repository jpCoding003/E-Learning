package com.tops.e_learning.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tops.e_learning.R
import com.tops.e_learning.databinding.FragmentReadQuestionsBinding

class ReadQuestionsFragment : Fragment() {

    private lateinit var binding: FragmentReadQuestionsBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReadQuestionsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_readQuestionsFragment_to_homeFragment)
        }

        binding.btnSQL.setOnClickListener {
            findNavController().navigate(R.id.action_readQuestionsFragment_to_SQLQuestionsFragment)
        }

        binding.btnFundamentals.setOnClickListener {
            findNavController().navigate(R.id.action_readQuestionsFragment_to_fundamentalsFragment)
        }
        binding.btnHrQues.setOnClickListener {
            findNavController().navigate(R.id.action_readQuestionsFragment_to_hrQuestionsFragment)
        }

    }
}