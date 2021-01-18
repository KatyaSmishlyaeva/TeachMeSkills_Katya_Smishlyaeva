package com.example.homework16

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.max

class MainActivity : AppCompatActivity() {

    @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Task1
        val butTask1: Button = findViewById(R.id.but_task1)
        butTask1.setOnClickListener {
            val a = et_number1.text.toString()
            val b = et_number2.text.toString()
            val text = try {
                val intA = a.toInt()
                val intB = b.toInt()
                multiplicationOrSum(intA, intB)
            } catch (e: NumberFormatException) {
                "Введите два числа!"
            }
            val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 200)
            toast.show()
        }

        //Task2
        val butTask2: Button = findViewById(R.id.but_task2)
        butTask2.setOnClickListener {
            val x = et_x.text.toString()
            val y = et_y.text.toString()
            val z = et_z.text.toString()
            val result = try {
                val intX = x.toInt()
                val intY = y.toInt()
                val intZ = z.toInt()
                max(intX * intY * intZ, intX + intY + intZ).toString()
            } catch (e: NumberFormatException) {
                "Введите три числа!"
            }
            val toast2 = Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT)
            toast2.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 500)
            toast2.show()
        }

        //Task3
        val butTask3: Button = findViewById(R.id.but_task3)
        butTask3.apply {
            text = "Введите рейтинг студента"
            textSize = 15.0F
            setBackgroundColor(Color.BLUE)
        }
        butTask3.setOnClickListener {
            val rating = et_rating.text.toString()
            val resultRating = try {
                val ratingInt = rating.toInt()
                when (ratingInt) {
                    in 0..19 -> "Оценка F"
                    in 20..39 -> "Оценка E"
                    in 40..59 -> "Оценка D"
                    in 60..74 -> "Оценка C"
                    in 75..89 -> "Оценка B"
                    in 90..100 -> "Оценка A"
                    else -> "Рейтинг должен быть от 0 до 100"
                }
            } catch (e: NumberFormatException) {
                "Проверьте введенные данные!"
            }

            val toast3 = Toast.makeText(applicationContext, resultRating, Toast.LENGTH_SHORT)
            toast3.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 700)
            toast3.show()
        }

        //Task4
        val butTask4: Button = findViewById(R.id.but_task4)
        butTask4.apply {
            text = "Введите размеры конвертов"
            textSize = 15.0F
            setBackgroundColor(Color.GREEN)
        }
        butTask4.setOnClickListener {
            val x1 = et_x1.text.toString()
            val y1 = et_y1.text.toString()
            val x2 = et_x2.text.toString()
            val y2 = et_y2.text.toString()
            val result = try {
                val intX1 = x1.toInt()
                val intY1 = y1.toInt()
                val intX2 = x2.toInt()
                val intY2 = y2.toInt()
                if (((intX1 < intX2) && (intY1 < intY2)) || ((intX1 < intY2) && (intY1 < intX2)) ||
                    ((intX2 < intX1) && (intY2 < intY1)) || ((intX2 < intY1) && (intY2 < intX1))
                )
                    "Можно вложить конверт!"
                else "Нельзя вложить конверт!"

            } catch (e: NumberFormatException) {
                "Проверьте введенные данные!"
            }
            val toast4 = Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT)
            toast4.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 900)
            toast4.show()
        }

        //Task5
        but_task5.setOnClickListener {
            val result = (2..99 step 2).sum()
            val counter = (99 - 1) / 2
            val sumAndCountEvenNumbers = "Четных чисел: $counter, сумма $result."
            val toast5 =
                Toast.makeText(applicationContext, sumAndCountEvenNumbers, Toast.LENGTH_SHORT)
            toast5.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 1200)
            toast5.show()
        }

        //Task6
        val butTask6: Button = findViewById(R.id.but_task6)
        butTask6.apply {
            text = "Введите число"
            textSize = 15.0F
            setBackgroundColor(Color.MAGENTA)
        }
        butTask6.setOnClickListener {
            val value = et_value.text.toString()
            val resultFactorial = try {
                val valueInt = value.toInt()
                when {
                    valueInt < 0 -> "Введите число больше 0"
                    else -> "Факториал $value = ${factorial(valueInt)}"
                }
            } catch (e: NumberFormatException) {
                "Введите число!"
            }
            val toast6 = Toast.makeText(applicationContext, resultFactorial, Toast.LENGTH_SHORT)
            toast6.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 1250)
            toast6.show()
        }

        //Task7
        val butTask7: Button = findViewById(R.id.but_task7)
        butTask7.apply {
            text = "Введите число"
            textSize = 15.0F
            setBackgroundColor(Color.RED)
        }
        butTask7.setOnClickListener {
            val value = et_value2.text.toString()
            val binaryValue = try {
                val valueInt = value.toInt()
                Integer.toBinaryString(valueInt)
            } catch (e: NumberFormatException) {
                "Введите целое число!"
            }
            val toast7 = Toast.makeText(applicationContext, binaryValue, Toast.LENGTH_SHORT)
            toast7.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 1550)
            toast7.show()
        }
    }

    fun multiplicationOrSum(a: Int, b: Int): String = when {
        a % 2 == 0 -> "$a * $b = ${a * b}"
        else -> "$a + $b = ${a + b}"
    }

    fun factorial(value: Int): Int {
        var result = 1
        for (i in 1..value) {
            result *= i
        }
        return result
    }
}