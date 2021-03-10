package com.example.smishlyaevakatya_navigation.ui.homework25

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.smishlyaevakatya_navigation.R
import com.example.smishlyaevakatya_navigation.ui.homework26.FurnitureApplication
import com.squareup.picasso.Picasso

class ItemFragment : Fragment() {

    private val viewModel: FurnitureViewModel by viewModels() {
        FurnitureViewModelFactory((this.activity?.application as FurnitureApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_new_furniture, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val info = view.findViewById<TextView>(R.id.tv_furniture_info)
        val inStock = view.findViewById<TextView>(R.id.tv_in_stock)
        val image = view.findViewById<ImageView>(R.id.iv_furniture)
        val buttonDelete = view.findViewById<Button>(R.id.btn_delete)

        val itemFurniture = arguments?.getParcelable<Furniture>("NAME")
        val tempInfo = itemFurniture?.name
        info.text = tempInfo
        inStock.text = itemFurniture?.isInStock
        itemFurniture?.let { loadImageAsync(itemFurniture.image, image) }

        buttonDelete.setOnClickListener {
            itemFurniture?.let {
                viewModel.deleteFurniture(itemFurniture)
            }
            Toast.makeText(context, "Удален", Toast.LENGTH_LONG).show()
            findNavController().navigate(
                R.id.action_global_navigation
            )
        }
    }

    fun loadImageAsync(path: String, image: ImageView) {
        Picasso.get()
            .load(path)
            .placeholder(R.drawable.download)
            .into(image)
    }
}