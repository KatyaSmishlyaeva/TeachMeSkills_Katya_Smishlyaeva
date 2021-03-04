package com.example.smishlyaevakatya_navigation.ui.homework25

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.smishlyaevakatya_navigation.R
import com.squareup.picasso.Picasso


class ItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frafment_item_new_furniture, container, false)
        val info = view.findViewById<TextView>(R.id.tv_furniture_info)
        val inStock = view.findViewById<TextView>(R.id.tv_in_stock)
        val image = view.findViewById<ImageView>(R.id.iv_furniture)

        var text = arguments?.getString("NAME")
        val stock = arguments?.getBoolean("STOCK")
        info.text = text
        inStock.text = if (stock == true) "В наличии." else "Под заказ."
        arguments?.getString("IMAGE")?.let { loadImageAsync(it, image) }

        return view
    }

    fun loadImageAsync(path: String, image: ImageView) {
        Picasso.get()
            .load(path)
            .placeholder(R.drawable.download)
            .into(image)
    }
}