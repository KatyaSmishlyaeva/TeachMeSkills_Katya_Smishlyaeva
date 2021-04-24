package com.example.coursewidjet.homework31

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.coursewidjet.R
import java.text.SimpleDateFormat
import java.util.*

class CourseActivity : AppCompatActivity() {

    private val viewModel: CourseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rv_course)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_course)
        val data = findViewById<TextView>(R.id.tv_data)
        val date = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = date.format(Date())
        data.text = currentDate

        viewModel.allCourse.observe(this, {
            recyclerView.adapter = CourseAdapter(it)
        })
    }
}

