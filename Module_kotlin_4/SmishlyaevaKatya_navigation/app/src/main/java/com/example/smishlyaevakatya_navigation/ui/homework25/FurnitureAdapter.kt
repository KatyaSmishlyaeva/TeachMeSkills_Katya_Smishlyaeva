package com.example.smishlyaevakatya_navigation.ui.homework25

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smishlyaevakatya_navigation.R
import com.squareup.picasso.Picasso

class FurnitureAdapter(
    var list: List<Furniture>,
    private val delegate: (Furniture) -> Unit
) :
    RecyclerView.Adapter<FurnitureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_furniture, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], delegate, position)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private var image = itemView.findViewById<ImageView>(R.id.iv_image)
        private var description = itemView.findViewById<TextView>(R.id.tv_description)
        private var stock = itemView.findViewById<TextView>(R.id.tv_available)

        private fun loadImageAsync(path: String) {
            Picasso.get()
                .load(path)
                .placeholder(R.drawable.download)
                .into(image)
        }

        fun bind(furniture: Furniture, delegate: (Furniture) -> Unit, position: Int) {
            loadImageAsync(furniture.image)
            description.text = furniture.name
            stock.text = "Склад"

            itemView.setOnClickListener {
                delegate(furniture)
            }
        }
    }
}