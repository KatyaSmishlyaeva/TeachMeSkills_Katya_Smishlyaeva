package com.example.smishlyaevakatya_android.homework20.view_model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.smishlyaevakatya_android.R
import kotlinx.android.synthetic.main.activity_view_model.*

class MySecondActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        viewModel.setup()
        viewModel.firstName.observe(this, Observer {
            tv_first_name.text = it
        })
        viewModel.lastName.observe(this, Observer {
            tv_last_name.text = it
        })
        viewModel.age.observe(this, Observer {
            tv_age.text = it.toString()
        })
    }
}