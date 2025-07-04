package com.tops.e_learning.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tops.e_learning.databinding.ItemQuestionBinding
import com.tops.e_learning.model.ReadQuestion

class QuestionAdapter(val questions: List<ReadQuestion>): RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuestionViewHolder {
        val binding = ItemQuestionBinding.inflate(LayoutInflater.from(parent.context),parent , false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: QuestionViewHolder,
        position: Int
    ) {
        val question = questions[position]
        // code where to implement
        holder.binding.tvQuestion.setText("Q${position+1}  "+question.question)
        holder.binding.tvAnswer.setText("Ans:-  "+question.answer)

    }

    override fun getItemCount(): Int {
        return questions.size
    }

    class QuestionViewHolder(val binding: ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root){
    }
}