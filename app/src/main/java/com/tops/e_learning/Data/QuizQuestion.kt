package com.tops.e_learning.Data

import com.tops.e_learning.model.PlayQuizModel

data class QuizQuestion(

    val questions: List<PlayQuizModel> = listOf(
        PlayQuizModel(1,"What is Your Name?","Jay","Heli","Jay Pacho","Kakkkka",1),
        PlayQuizModel(2,"What is Your Name?","Jay","Heli","Jay Pacho","Kakkkka",2),
        PlayQuizModel(3,"What is Your Name?","Jay","Heli","Jay Pacho","Kakkkka",2),
        PlayQuizModel(4,"What is Your Name?","Jay","Heli","Jay Pacho","Kakkkka",4),
        PlayQuizModel(5,"What is Your Name?","Jay","Heli","Jay Pacho","Kakkkka",3),
        PlayQuizModel(6,"What is Your Name?","Jay","Heli","Jay Pacho","Kakkkka",1)
    )

)