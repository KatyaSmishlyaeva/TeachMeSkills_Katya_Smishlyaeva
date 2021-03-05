package com.example.smishlyaevakatya_navigation.ui.homework25

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.smishlyaevakatya_navigation.R
import com.example.smishlyaevakatya_navigation.ui.homework26.FurnitureApplication

class FurnitureFragment : Fragment() {

    private lateinit var buttonAdd: Button
    private lateinit var rvFurniture: RecyclerView
    private val viewModel: FurnitureViewModel by viewModels() {
        FurnitureViewModelFactory((this.activity?.application as FurnitureApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_furniture, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAdd = view.findViewById(R.id.btn_add)
        rvFurniture = view.findViewById(R.id.rv_furniture)

        buttonAdd.setOnClickListener {
            findNavController().navigate(
                R.id.action_global_insertFurnitureFragment
            )
        }

        viewModel.allFurniture.observe(viewLifecycleOwner, Observer { list ->
            val adapter = FurnitureAdapter(list) {
                val bundle = Bundle()
                bundle.putParcelable("NAME", it)
                findNavController().navigate(
                    R.id.action_navigation_furniture_to_navigation_item_furniture,
                    bundle
                )
            }
            rvFurniture.adapter = adapter
        })
    }
}