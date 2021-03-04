package com.example.smishlyaevakatya_navigation.ui.homework25

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.smishlyaevakatya_navigation.R

class FurnitureFragment : Fragment(), OnItemVClickListener {

    private lateinit var furnitureViewModel: FurnitureViewModel
    private val viewModel: FurnitureViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        furnitureViewModel =
            ViewModelProvider(this).get(FurnitureViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_furniture, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvFurniture = view.findViewById<RecyclerView>(R.id.rv_furniture)
        viewModel.setUp()
        viewModel.furnitureList.observe(viewLifecycleOwner, Observer {
            val adapter = FurnitureAdapter(it, this)
            rvFurniture.adapter = adapter
        })
    }

    override fun onItemClick(item: Furniture, position: Int) {
        val bundle = Bundle()
        bundle.putString("NAME", item.name)
        bundle.putBoolean("STOCK", item.isInStock)
        bundle.putString("IMAGE", item.image)
        findNavController().navigate(
            R.id.action_navigation_furniture_to_navigation_item_furniture,
            bundle
        )
    }
}

