package com.example.smishlyaevakatya_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smishlyaevakatya_android.homework17.MyTimer
import com.example.smishlyaevakatya_android.homework18.Harvesting
import com.example.smishlyaevakatya_android.homework20.lifecycle_activity.MyActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_hw17.setOnClickListener {
            val intent = Intent(this, MyTimer::class.java)
            startActivity(intent)
        }

        btn_hw18.setOnClickListener {
            val intent = Intent(this, Harvesting::class.java)
            startActivity(intent)
        }

        btn_hw20.setOnClickListener {
            val intent = Intent(this, MyActivity::class.java)
            startActivity(intent)
        }
    }
}