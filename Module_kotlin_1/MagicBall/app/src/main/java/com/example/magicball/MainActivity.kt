package com.example.magicball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            val text = et_hello.text.toString()
            if (text == "") tv_result.text = "Вопрос не задан"
            else tv_result.text = randomAnswer()
        }
    }

    fun randomAnswer(): String {
        val list = arrayOf("Да", "Нет", "Скорее всего", "Скорее всего да", "Скорее всего нет", "Возможно", "Вопрос задан неверно")
        val index: Int = (0..6).random()
        return list[index]
    }
}