package com.tops.e_learning.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tops.e_learning.R
import com.tops.e_learning.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
   private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogout.setOnClickListener {
            val sharedPref = activity?.getSharedPreferences(
                getString(R.string.app_name),
                Context.MODE_PRIVATE
            )
            sharedPref?.edit()?.apply {
                clear() // remove EMAIL, PASSWORD, IS_LOGIN
                apply()
            }

            // Navigate back to LoginFragment
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)

        }
    }
}