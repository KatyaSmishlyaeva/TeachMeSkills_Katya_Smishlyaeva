package com.example.smishlyaevakatya_navigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.smishlyaevakatya_navigation.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvWelcome = view.findViewById<TextView>(R.id.tv_welcome)
        AnimationUtils.loadAnimation(context, R.anim.button).also {
            val button24 = view.findViewById<Button>(R.id.btn_hm24)
            val button25 = view.findViewById<Button>(R.id.btn_hm25)
            button24.startAnimation(it)
            button25.startAnimation(it)
        }

        AnimationUtils.loadAnimation(context, R.anim.text).also {
            tvWelcome.startAnimation(it)
        }

        tvWelcome.setOnClickListener {
            AnimationUtils.loadAnimation(context, R.anim.rotate).also {
                tvWelcome.startAnimation(it)
            }
        }

        val button24 = view.findViewById<Button>(R.id.btn_hm24)
        button24.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard2)
        }

        val button25 = view.findViewById<Button>(R.id.btn_hm25)
        button25.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_furniture)
        }
        val button27 = view.findViewById<Button>(R.id.btn_hm27)
        button27.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_factsFragment)
        }
    }
}

