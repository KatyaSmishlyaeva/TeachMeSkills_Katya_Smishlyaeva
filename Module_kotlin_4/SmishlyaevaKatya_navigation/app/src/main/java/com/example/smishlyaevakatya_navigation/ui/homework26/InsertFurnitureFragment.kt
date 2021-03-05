package com.example.smishlyaevakatya_navigation.ui.homework26

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.smishlyaevakatya_navigation.R
import com.example.smishlyaevakatya_navigation.ui.homework25.Furniture
import com.example.smishlyaevakatya_navigation.ui.homework25.FurnitureViewModel
import com.example.smishlyaevakatya_navigation.ui.homework25.FurnitureViewModelFactory

class InsertFurnitureFragment : Fragment() {

    private lateinit var button: Button
    private lateinit var info: EditText
    private lateinit var stock: EditText
    private lateinit var image: EditText
    private val viewModel: FurnitureViewModel by viewModels() {
        FurnitureViewModelFactory((this.activity?.application as FurnitureApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.insert_fragment_furniture, container, false)
        for (element in viewModel.listFurniture)
            viewModel.addFurniture(element)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.btn_enter)
        info = view.findViewById(R.id.et_into)
        stock = view.findViewById(R.id.et_stock)
        image = view.findViewById(R.id.et_image)

        button.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val info = info.text.toString()
        val stock = stock.text.toString()
        val image = image.text.toString()

        viewModel.addFurniture(Furniture(info, image, stock))
        Toast.makeText(context, "Добавлен", Toast.LENGTH_LONG).show()
        findNavController().navigate(
            R.id.action_insertFurnitureFragment_to_navigation
        )
    }
}