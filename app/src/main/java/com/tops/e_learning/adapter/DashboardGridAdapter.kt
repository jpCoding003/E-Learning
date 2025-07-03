package com.tops.e_learning.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.constraintlayout.motion.widget.KeyPosition
import com.tops.e_learning.databinding.GridItemBinding

class DashboardGridAdapter(private val context: Context, private val items: List<String>) : BaseAdapter() {
    override fun getCount()= items.size

    override fun getItem(position: Int)= items[position]

    override fun getItemId(position: Int)= position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: GridItemBinding

        val view: View
        if (convertView == null) {
            binding = GridItemBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as GridItemBinding
        }

        binding.gridText.text = items[position]
        return view
    }
}