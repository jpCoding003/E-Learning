package com.tops.e_learning

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tops.e_learning.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

   private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences(getString(R.string.app_name),Context.MODE_PRIVATE)
        val IS_LOGIN = "IS_LOGIN"
        val isLogin= sharedPref?.getBoolean(IS_LOGIN,false)

        Handler(Looper.getMainLooper()).postDelayed({

            if (isLogin == true){
                val intent = Intent(this, DashBoardActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}