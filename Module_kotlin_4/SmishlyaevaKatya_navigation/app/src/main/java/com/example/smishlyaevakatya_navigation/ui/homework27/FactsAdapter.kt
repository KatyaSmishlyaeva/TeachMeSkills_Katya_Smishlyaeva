package com.example.smishlyaevakatya_navigation.ui.homework27

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smishlyaevakatya_navigation.R
import com.example.smishlyaevakatya_navigation.ui.homework27.model.Facts

class FactsAdapter(val list: List<Facts>) :
    RecyclerView.Adapter<FactsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_text)
        val type: TextView = view.findViewById(R.id.tv_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_facts, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].text
        holder.type.text = list[position].type
    }

    override fun getItemCount(): Int = list.size
}