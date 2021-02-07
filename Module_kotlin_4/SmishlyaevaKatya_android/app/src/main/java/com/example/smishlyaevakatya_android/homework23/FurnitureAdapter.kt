package com.example.smishlyaevakatya_android.homework23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smishlyaevakatya_android.R
import com.squareup.picasso.Picasso

class FurnitureAdapter(val list: List<Furniture>) :
    RecyclerView.Adapter<FurnitureAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.iv_image)
        private val description = view.findViewById<TextView>(R.id.tv_description)
        private val stock = view.findViewById<TextView>(R.id.tv_available)

        fun loadImageAsync(path: String) {
            Picasso.get()
                .load(path)
                .placeholder(R.drawable.ic_baseline_hourglass_bottom_24)
                .into(image)
        }

        fun bind(furniture: Furniture) {
            loadImageAsync(furniture.image)
            description.text = furniture.name
            stock.text = if (furniture.isInStock) "Склад" else " Нету"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_furniture, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}