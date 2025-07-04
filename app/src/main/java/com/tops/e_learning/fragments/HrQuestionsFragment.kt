package com.tops.e_learning.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tops.e_learning.R
import com.tops.e_learning.adapter.QuestionAdapter
import com.tops.e_learning.databinding.FragmentFundamentalsBinding
import com.tops.e_learning.databinding.FragmentHrQuestionsBinding
import com.tops.e_learning.databinding.FragmentLoginBinding
import com.tops.e_learning.staticQA

class HrQuestionsFragment : Fragment() {

    private lateinit var binding: FragmentHrQuestionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHrQuestionsBinding.inflate(layoutInflater)
        return binding.root
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hr_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val quest = staticQA.HrQuestionsData

        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_hrQuestionsFragment_to_readQuestionsFragment)
        }
        binding.rvQuestion.layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuestion.adapter = QuestionAdapter(quest)
    }

}