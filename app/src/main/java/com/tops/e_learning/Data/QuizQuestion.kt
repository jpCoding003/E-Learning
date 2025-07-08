package com.tops.e_learning.Data

import com.tops.e_learning.model.PlayQuizModel

data class QuizQuestion(

    val questions: List<PlayQuizModel> = listOf(
        // Android Quiz Questions
        PlayQuizModel(1, "What is an Activity in Android?", "A background service", "A screen with UI", "A type of file", "A database", 2),
        PlayQuizModel(2, "What does the AndroidManifest.xml file do?", "Stores images", "Handles app layout", "Declares app components", "Connects to internet", 3),
        PlayQuizModel(3, "Which lifecycle method is called first in an Activity?", "onPause()", "onStart()", "onCreate()", "onResume()", 3),
        PlayQuizModel(4, "What is the function of Intent in Android?", "Design UI", "Handle database", "Start components", "Play music", 3),
        PlayQuizModel(5, "Which component has no UI but runs in the background?", "Activity", "Fragment", "View", "Service", 4),

        // SQL Quiz Questions
        PlayQuizModel(6, "What is the purpose of SQL?", "Design websites", "Manage files", "Manage relational databases", "Draw diagrams", 3),
        PlayQuizModel(7, "Which SQL clause is used to filter groups?", "WHERE", "HAVING", "GROUP BY", "ORDER BY", 2),
        PlayQuizModel(8, "What is a Primary Key?", "A unique identifier", "A duplicate value", "A table header", "A user password", 1),
        PlayQuizModel(9, "What does a JOIN do in SQL?", "Deletes data", "Combines rows from tables", "Creates tables", "Sorts data", 2),
        PlayQuizModel(10, "Which SQL function returns the number of rows?", "AVG()", "SUM()", "COUNT()", "MIN()", 3)
    )
)