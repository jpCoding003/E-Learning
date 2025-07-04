package com.tops.e_learning.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.tops.e_learning.R
import com.tops.e_learning.adapter.DashboardGridAdapter
import com.tops.e_learning.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
   private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.show()
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Dashboard"

        val dashboardOptions = listOf("Read Questions", "Play Quiz")
        val adapter = DashboardGridAdapter(requireContext(), dashboardOptions)
        binding.gridOptions.adapter = adapter

        binding.gridOptions.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> findNavController().navigate(R.id.action_homeFragment_to_readQuestionsFragment)
                1 -> findNavController().navigate(R.id.action_homeFragment_to_playQuizFragment)
            }
        }


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
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_us -> {
                Toast.makeText(context, "ECORP is an interview preparation app for job seekers.", Toast.LENGTH_LONG).show()
            }
            R.id.contact_us -> {
                Toast.makeText(context, "Contact us at: support@ecorp.com", Toast.LENGTH_LONG).show()
            }
            R.id.logout -> {
                val sharedPref = activity?.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
                sharedPref?.edit()?.clear()?.apply()
                findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
            }
        }
        return true
    }

}