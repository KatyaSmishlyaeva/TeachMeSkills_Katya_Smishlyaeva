package com.example.sumofdigits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_sumdigits.setOnClickListener {
            val userInput = et_number.text.toString()
            var value = 0
            try {
                value = userInput.toInt()
                tv_result.text = "Сумма цифр числа $userInput - ${sumOfDigits(value)}"
            } catch (e: NumberFormatException) {
                tv_result.text = "Введите число"
            }
        }

        btn_sum.setOnClickListener {
            var result = 0
            for (i in 1..100) {
                result += i
            }
            tv_sum.text = result.toString()
        }
    }

    private fun sumOfDigits(value: Int): Int {
        var isZero = false
        var result = 0
        var temp = value
        while (!isZero) {
            result += temp % 10
            temp /= 10
            if (temp == 0) isZero = true
        }
        return result
    }
}