package com.example.smishlyaevakatya_android.homework23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.smishlyaevakatya_android.R

class FurnitureFragment : Fragment() {

    private val viewModel: FurnitureViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_furniture, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvFurniture = view.findViewById<RecyclerView>(R.id.rv_furniture)
        viewModel.setUp()
        viewModel.furnitureList.observe(viewLifecycleOwner, Observer {
            val list = it
            val adapter = FurnitureAdapter(list)
            rvFurniture.adapter = adapter
        })
    }
}