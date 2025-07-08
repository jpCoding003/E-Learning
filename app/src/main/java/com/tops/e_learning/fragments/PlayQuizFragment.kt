package com.tops.e_learning.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.tops.e_learning.R
import com.tops.e_learning.ViewModels.QuizViewModel
import com.tops.e_learning.databinding.FragmentPlayQuizBinding
import com.tops.e_learning.model.PlayQuizModel

class PlayQuizFragment : Fragment() {

    private lateinit var binding: FragmentPlayQuizBinding
    private  val quizviewmodel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayQuizBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quizviewmodel.questions.observe(viewLifecycleOwner, Observer<PlayQuizModel?>{
            question->
            if (question == null){
                showScore()
            }else{
                binding.tvQuestion.setText(question.Question)
                binding.tvoption1.setText(question.Option1)
                binding.tvoption2.setText(question.Option2)
                binding.tvoption3.setText(question.Option3)
                binding.tvoption4.setText(question.Option4)
            }
        })

        quizviewmodel.loadnextquestion()

        binding.tvoption1.setOnClickListener { optionClicked(1) }
        binding.tvoption2.setOnClickListener { optionClicked(2) }
        binding.tvoption3.setOnClickListener { optionClicked(3) }
        binding.tvoption4.setOnClickListener { optionClicked(4) }
    }

    private fun optionClicked(selectedoption: Int){
        val correctopt = quizviewmodel.checkanswer(selectedoption)
        if (correctopt){
            Toast.makeText(requireActivity(),"Correct",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireActivity(),"InCorrect",Toast.LENGTH_SHORT).show()
        }
        quizviewmodel.loadnextquestion()
    }

    private fun showScore() {
        AlertDialog.Builder(requireContext())
            .setTitle("Quiz Finished 🎉")
            .setMessage("Your Score: ${quizviewmodel.getscore()} / ${quizviewmodel.quizquestions.size}")
            .setPositiveButton("OK") { _, _ -> requireActivity().onBackPressedDispatcher.onBackPressed() }
            .show()
    }


}


