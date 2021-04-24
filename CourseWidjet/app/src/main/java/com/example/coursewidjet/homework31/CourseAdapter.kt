package com.example.coursewidjet.homework31

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coursewidjet.R
import com.example.coursewidjet.homework31.model.CourseItem

class CourseAdapter(private val list: List<CourseItem>) :
    RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val scale: TextView = view.findViewById(R.id.tv_cur_scale)
        val abbreviation: TextView = view.findViewById(R.id.tv_cur_abbreviation)
        val officialRate: TextView = view.findViewById(R.id.tv_cur_official_rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.scale.text = list[position].Cur_Scale.toString()
        holder.abbreviation.text = list[position].Cur_Abbreviation
        holder.officialRate.text = list[position].Cur_OfficialRate.toString()
    }

    override fun getItemCount(): Int = list.size
}