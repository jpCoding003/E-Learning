package com.tops.e_learning.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tops.e_learning.HomeScreenActivity
import com.tops.e_learning.R
import com.tops.e_learning.databinding.FragmentLoginBinding

val IS_LOGIN = "IS_LOGIN"
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                replace<RegisterFragment>(R.id.main_container)
            }
        }

        binding.btnlogin.setOnClickListener {

            val sharedPref = activity?.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)?: return@setOnClickListener
            with(sharedPref.edit()){
                this!!.putBoolean(IS_LOGIN,true)
                    .apply()
            }
            val email = sharedPref?.getString(EMAIL,null)
            val password = sharedPref?.getString(PASSWORD,null)

            if (validity()){
                if (binding.etEmail.text.toString().equals(email) && binding.etPassword.text.toString().equals(password)) {
                    val intent = Intent(context, HomeScreenActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(context, "Email Password Not Registered!!", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(context, "Enter Details Properly", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validity(): Boolean{

        var isValid = true
        if (binding.etEmail.text.toString().isEmpty()){
            binding.etEmail.error = "*Require"
            isValid= false
        }
        else{
            binding.etEmail.error = null
            isValid = true
        }
        if (binding.etPassword.text.toString().isEmpty()){
            binding.etPassword.error = "*Require"
            isValid= false
        }else{
            binding.etPassword.error = null
            isValid = true
        }

        if (binding.etPassword.length()< 8){
            binding.etPassword.setError("*Min. size must 8 Char")
            isValid= false
        }else{
            binding.etPassword.error = null
            isValid = true
        }

        //After All this validation
        //Will return True
        return isValid
    }

}