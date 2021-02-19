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
    var clickListener: OnItemVClickListener
) :
    RecyclerView.Adapter<FurnitureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_furniture, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], clickListener)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private var image = itemView.findViewById<ImageView>(R.id.iv_image)
        private var description = itemView.findViewById<TextView>(R.id.tv_description)
        private var stock = itemView.findViewById<TextView>(R.id.tv_available)

         fun loadImageAsync(path: String) {
            Picasso.get()
                .load(path)
                .placeholder(R.drawable.download)
                .into(image)
        }

        fun bind(furniture: Furniture, action: OnItemVClickListener) {
            loadImageAsync(furniture.image)
            description.text = furniture.name
            stock.text = if (furniture.isInStock) "Склад" else " Нету"

            itemView.setOnClickListener {
                action.onItemClick(furniture, adapterPosition)
            }
        }
    }
}

interface OnItemVClickListener {
    fun onItemClick(item: Furniture, position: Int)
}