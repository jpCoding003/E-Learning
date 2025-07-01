package com.tops.e_learning

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import com.tops.e_learning.databinding.ActivityMainBinding
import com.tops.e_learning.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.navView.post {
            val navController = binding.navView.findNavController()

            val sharedPref = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("IS_LOGIN", false)

            if (isLogin) {
                navController.navigate(R.id.homeFragment)
            } else {
                // No need to navigate manually if loginFragment is already startDestination
                // navController.navigate(R.id.loginFragment)
            }
        }

    }
}