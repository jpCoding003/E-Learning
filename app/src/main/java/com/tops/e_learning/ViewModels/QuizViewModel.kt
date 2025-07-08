package com.tops.e_learning.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tops.e_learning.Data.QuizQuestion
import com.tops.e_learning.model.PlayQuizModel

class QuizViewModel: ViewModel(){

     var quizquestions = QuizQuestion().questions

    private var  curretIndex = 0
    private var score = 0


    private val _questions = MutableLiveData<PlayQuizModel?>()
    val questions : MutableLiveData<PlayQuizModel?> =  _questions

    fun loadnextquestion(){
        if (curretIndex < quizquestions.size){
            _questions.value = quizquestions[curretIndex]
        }else{
            _questions.value = null
        }
    }

    fun checkanswer(selectedoption: Int): Boolean{
        if (curretIndex >= quizquestions.size) return false

        val correct = quizquestions[curretIndex].CorrectAns== selectedoption
        if (correct == true) score++
        curretIndex++
        return correct
    }

    fun getscore():Int = score

}