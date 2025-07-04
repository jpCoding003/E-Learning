package com.tops.e_learning.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
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

        (activity as AppCompatActivity).supportActionBar?.hide()

        binding.btnRegister.setOnClickListener {
           findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnlogin.setOnClickListener {

            val sharedPref = activity?.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)?: return@setOnClickListener
            with(sharedPref.edit()){
                this!!.putBoolean(IS_LOGIN,true)
                    .apply()
            }
            val email = sharedPref.getString(EMAIL,null)
            val password = sharedPref.getString(PASSWORD,null)

            if (validity()==true){
                if (binding.etEmail.text.toString() == email && binding.etPassword.text.toString() == password) {
                   findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
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