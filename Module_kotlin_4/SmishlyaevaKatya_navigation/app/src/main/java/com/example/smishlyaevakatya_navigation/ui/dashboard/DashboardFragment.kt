package com.example.smishlyaevakatya_navigation.ui.dashboard

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.smishlyaevakatya_navigation.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var portalAnimation: AnimationDrawable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val portal = view.findViewById<ImageView>(R.id.iv_portal).apply {
            setBackgroundResource(R.drawable.portal_anim)
            portalAnimation = background as AnimationDrawable
            portalAnimation.start()
        }
        portal.setOnClickListener {
            portalAnimation.stop()
        }

        val backHome = view.findViewById<Button>(R.id.btn_home)
        backHome.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_home2)
        }
    }
}