package com.tops.e_learning.model

data class PlayQuizModel(
    val id: Int,
    val Question: String,
    val Option1: String,
    val Option2: String,
    val Option3: String,
    val Option4: String,
    val CorrectAns: Int
)
