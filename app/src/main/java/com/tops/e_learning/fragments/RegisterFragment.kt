package com.tops.e_learning.fragments

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import com.tops.e_learning.R
import com.tops.e_learning.databinding.FragmentRegisterBinding

val EMAIL = "EMAIL"
val PASSWORD = "PASSWORD"

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            if (validity()){
                val sharedpref = activity?.getSharedPreferences(getString(R.string.app_name),Context.MODE_PRIVATE)?: return@setOnClickListener

                with(sharedpref.edit()){
                    putString(EMAIL, binding.etEmail.text.toString())
                    putString(PASSWORD, binding.etpassword.text.toString())
                    apply()
                }

               findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
            else{
                Toast.makeText(context, "Enter Proper Details", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnlogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun validity(): Boolean{

        var isValid = true
        if (binding.etFirstname.text.toString().isEmpty()){
            binding.etFirstname.error = "Require"
//            return false
            isValid = false
        }
        else{
            binding.etFirstname.error = null
            isValid = true
        }

        if (binding.etLastname.text.toString().isEmpty()){
            binding.etLastname.error = "Require"
//            return falss
            isValid = false
        }else{
            binding.etLastname.error = null
            isValid = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()){
            binding.etEmail.error = "Enter Valid Email Address"
            isValid = false
        }else{
            binding.etEmail.error = null
            isValid = true
        }

        if (binding.etpassword.length()< 8 || binding.etpassword.text.toString().isEmpty() ){
            binding.etpassword.setError("Min. size must 8 Char")
            isValid = false
        }else{
            binding.etpassword.error = null
        }

        if (binding.etpassword.text.toString() != binding.etConfirmPassword.text.toString()){
            binding.etConfirmPassword.error =  "Password Did not Matched!!"
            isValid = false
        }else{
            binding.etConfirmPassword.error = null
            isValid = true
        }

        //After All this validation
        //Will return True
        return isValid
    }

}