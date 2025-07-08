package com.tops.e_learning

import com.tops.e_learning.model.ReadQuestion

object staticQA{

    val FundamentalQuestionsData  : MutableList<ReadQuestion> = mutableListOf(
        ReadQuestion("What is Android?",
            "Android is an open-source operating system developed by Google for mobile devices like smartphones and tablets."
        ),
        ReadQuestion(
            "What is an Activity in Android?",
            "An Activity represents a single screen with a user interface in an Android app."
        ),
        ReadQuestion(
            "What is an Intent in Android?",
            "An Intent is a messaging object used to request an action from another component (e.g., starting an Activity or Service)."
        ),ReadQuestion(
            " What is the AndroidManifest.xml file?",
            "It is a configuration file that declares components, permissions, and other essential app info to the Android system."
        ),ReadQuestion(
            "What is a Fragment?",
            "A Fragment is a reusable portion of UI that can be embedded in an Activity."
        ),ReadQuestion(
            "What is a View in Android?",
            "A View is the basic building block for user interface components like buttons, text fields, etc."
        ),ReadQuestion(
            "What is the lifecycle of an Activity?",
            "onCreate() → onStart() → onResume() → onPause() → onStop() → onDestroy()"
        ),
        ReadQuestion(
            "What Is Full Form of SQL?",
            "Structured Query Language."
        ),
        ReadQuestion(
            "What is a Service in Android?",
            "A Service is a background component that performs long-running operations without a user interface."
        ),
        ReadQuestion(
            "What is a BroadcastReceiver?",
            "It is a component that responds to broadcast messages from other apps or the system (e.g., low battery)."
        ),ReadQuestion(
            "What is ViewModel in Android?",
            "ViewModel stores and manages UI-related data in a lifecycle-conscious way to survive configuration changes."
        )
    )

    val SQLQuestions: MutableList<ReadQuestion> = mutableListOf(
        ReadQuestion(
            "What is SQL?",
            "SQL (Structured Query Language) is used to manage and manipulate relational databases."
        ),
        ReadQuestion(
            "What is a Primary Key?",
            "A Primary Key uniquely identifies each record in a table. It cannot be null or duplicated."
        ),
        ReadQuestion(
            "What is a Foreign Key?",
            "A Foreign Key is a column that creates a relationship between two tables, referencing the Primary Key in another table."
        ),
        ReadQuestion(
            "What is the difference between DELETE and TRUNCATE?",
            "DELETE removes specific rows and can be rolled back. TRUNCATE removes all rows quickly and cannot be rolled back."
        ),
        ReadQuestion(
            "What is a JOIN?",
            "A JOIN is used to combine rows from two or more tables based on a related column."
        ),
        ReadQuestion(
            "Types of JOINs in SQL?",
            "INNER JOIN, LEFT JOIN, RIGHT JOIN, FULL JOIN - all used to combine data from multiple tables."
        ),
        ReadQuestion(
            "What is a View in SQL?",
            "A View is a virtual table created by a query, used to simplify complex queries or secure data."
        ),
        ReadQuestion(
            "What is the difference between WHERE and HAVING?",
            "WHERE filters rows before grouping. HAVING filters groups after GROUP BY."
        ),
        ReadQuestion(
            "What is a Constraint?",
            "Constraints are rules enforced on table columns like NOT NULL, UNIQUE, PRIMARY KEY, CHECK, etc."
        ),
        ReadQuestion(
            "What is normalization?",
            "Normalization organizes data to reduce redundancy and improve data integrity."
        ),
        ReadQuestion(
            "What is a Subquery?",
            "A Subquery is a query inside another SQL query, used to fetch data based on results of another query."
        ),
        ReadQuestion(
            "What is the difference between CHAR and VARCHAR?",
            "CHAR is fixed-length, VARCHAR is variable-length and saves space."
        ),
        ReadQuestion(
            "What is the purpose of GROUP BY?",
            "GROUP BY groups rows with the same values and is often used with aggregate functions."
        ),
        ReadQuestion(
            "What are aggregate functions in SQL?",
            "Functions like SUM(), COUNT(), AVG(), MIN(), MAX() that operate on a set of values."
        ),
        ReadQuestion(
            "What is a stored procedure?",
            "A stored procedure is a precompiled group of SQL statements that can be executed as a unit."
        )
    )

    val HrQuestionsData: MutableList<ReadQuestion> = mutableListOf(
        ReadQuestion(
            "Tell me about yourself.",
            "I'm a motivated individual with a background in software development, eager to contribute and grow in a professional environment."
        ),
        ReadQuestion(
            "What are your strengths?",
            "My key strengths are problem-solving, adaptability, and strong communication skills."
        ),
        ReadQuestion(
            "What are your weaknesses?",
            "I sometimes overanalyze tasks, but I’m learning to manage my time better and prioritize effectively."
        ),
        ReadQuestion(
            "Why should we hire you?",
            "Because I bring strong technical skills, a quick learning ability, and a positive attitude toward teamwork and challenges."
        ),
        ReadQuestion(
            "Where do you see yourself in 5 years?",
            "I see myself in a senior role, contributing to impactful projects and mentoring juniors."
        ),
        ReadQuestion(
            "Why do you want to work for this company?",
            "Your company values innovation and learning, which aligns with my career goals and interests."
        ),
        ReadQuestion(
            "What are your salary expectations?",
            "I'm open to negotiation and willing to accept a fair offer based on my skills and the role."
        ),
        ReadQuestion(
            "Are you willing to relocate?",
            "Yes, I’m open to relocation if the opportunity supports my career growth."
        ),
        ReadQuestion(
            "Can you work under pressure?",
            "Yes, I see pressure as a motivator and prioritize tasks effectively to manage deadlines."
        ),
        ReadQuestion(
            "Describe a challenging situation and how you handled it.",
            "During a group project, we faced delays, so I took initiative to reallocate tasks and meet the deadline successfully."
        ),
        ReadQuestion(
            "What motivates you?",
            "Learning new skills, solving real-world problems, and seeing my efforts make an impact motivates me."
        ),
        ReadQuestion(
            "Are you a team player?",
            "Absolutely. I enjoy collaborating and believe teamwork leads to better solutions and learning."
        ),
        ReadQuestion(
            "How do you handle criticism?",
            "I take criticism constructively and use it as an opportunity to grow and improve."
        ),
        ReadQuestion(
            "What do you know about our company?",
            "Your company is known for its innovation, strong work culture, and commitment to employee growth."
        ),
        ReadQuestion(
            "Do you have any questions for us?",
            "Yes, could you please tell me more about the growth opportunities and training programs in your company?"
        )
    )

}
