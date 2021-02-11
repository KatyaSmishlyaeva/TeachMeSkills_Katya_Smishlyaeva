package com.example.smishlyaevakatya_navigation.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.smishlyaevakatya_navigation.MainActivity
import com.example.smishlyaevakatya_navigation.R
import com.example.smishlyaevakatya_navigation.ui.dashboard.DashboardFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

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
        AnimationUtils.loadAnimation(context, R.anim.button).also {
            btn_hm24.startAnimation(it)
        }

        AnimationUtils.loadAnimation(context, R.anim.text).also {
            tv_welcome.startAnimation(it)
        }

        tv_welcome.setOnClickListener {
            AnimationUtils.loadAnimation(context, R.anim.rotate).also {
                tv_welcome.startAnimation(it)
            }
        }

        val button24 = view.findViewById<Button>(R.id.btn_hm24)
        button24.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard2)
        }
    }
}

