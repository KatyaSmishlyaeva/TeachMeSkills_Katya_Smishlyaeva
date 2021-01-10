package com.example.randomnumbers

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            val randomValue = (5..155).random()
            if (randomValue in 26..99) tv_result.text = "$randomValue в интервале (25;100)"
            else tv_result.text = "$randomValue не в интервале (25;100)"
        }
    }
}