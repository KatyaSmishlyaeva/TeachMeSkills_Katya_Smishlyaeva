package com.example.puzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val map: MutableMap<String, String> = HashMap()
        map["Олень"] = "Кто на своей голове лес носит?"
        map["Собака"] = "С хозяином дружит, дом сторожит, живет под крылечком, хвост колечком"
        map["Хомяк"] = "У меня живет зверек, толстобрюх и толстощек."
        map["Коза"] = "Почти как барашек но без кудряшек."

        for ((key, value) in map) {
            println(value)
            println("Ваш ответ:")
            var answer: String? = readLine()
            while (!key.equals(answer, ignoreCase = true)) {
                println("Ваш ответ не правильный")
                answer = readLine()
            }
            println("Вы угадали")
        }
    }
}
