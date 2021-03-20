package com.example.smishlyaevakatya_android.homework20.view_model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.smishlyaevakatya_android.R
import kotlinx.android.synthetic.main.fragment_model.*

class ModelFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_model, container, false)
        viewModel.setup()
        viewModel.name.observe(viewLifecycleOwner, Observer {
            tv_fr_model.text = it
        })
        return view
    }
}