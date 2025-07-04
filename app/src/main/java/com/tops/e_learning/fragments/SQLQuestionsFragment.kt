package com.tops.e_learning.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tops.e_learning.R
import com.tops.e_learning.adapter.QuestionAdapter
import com.tops.e_learning.databinding.FragmentSQLQuestionsBinding
import com.tops.e_learning.staticQA


class SQLQuestionsFragment : Fragment() {

    private lateinit var binding: FragmentSQLQuestionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSQLQuestionsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val quest = staticQA.SQLQuestions

        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_SQLQuestionsFragment_to_readQuestionsFragment)
        }

        binding.rvQuestion.layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuestion.adapter = QuestionAdapter(quest)
    }
}