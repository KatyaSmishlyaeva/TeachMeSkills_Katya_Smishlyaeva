package com.example.smishlyaevakatya_android.homework23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smishlyaevakatya_android.R
import kotlinx.android.synthetic.main.activity_furniture.*

class FurnitureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furniture)

        btn_back_furniture.setOnClickListener {
            this.onBackPressed()
        }

        val value = FurnitureFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fr_container_furniture, value)
            .addToBackStack(null)
            .commit()
    }
}