package com.example.jumpingcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cats = arrayOf(Cat("Мурзик", 6, "Черный", 50, 70),
                Cat("Васька", 7, "Рыжий", 45, 60),
                Cat("Фунтик", 8, "Белый", 55, 70))
        val table = Table(110, "белый", "дерево", 120)


        var count = 0
        btn_jump.setOnClickListener() {
            if (isCatJumped(cats[count], table))
                tv_result.text = "${cats[count].name} прыгнул на ${cats[count].jumpHeight()} см и запрыгнул на стол"
            else
                tv_result.text = "${cats[count].name} прыгнул на ${cats[count].jumpHeight()} см и не запрыгнул на стол"
            count++
            if (count == cats.size)
                count = 0
        }
    }

    fun isCatJumped(cat: Cat, table: Table): Boolean {
        return cat.jumpHeight() >= table.height
    }
}
