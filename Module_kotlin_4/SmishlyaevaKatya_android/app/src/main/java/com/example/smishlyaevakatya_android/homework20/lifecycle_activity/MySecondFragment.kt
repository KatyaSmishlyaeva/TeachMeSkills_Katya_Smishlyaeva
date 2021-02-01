package com.example.smishlyaevakatya_android.homework20.lifecycle_activity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.smishlyaevakatya_android.R
import kotlinx.android.synthetic.main.fragment_my_second.*

class MySecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_second, container, false)
        return view
    }
}