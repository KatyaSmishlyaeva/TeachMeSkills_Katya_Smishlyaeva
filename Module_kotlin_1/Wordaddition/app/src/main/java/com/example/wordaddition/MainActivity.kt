package com.example.wordaddition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val array = charArrayOf(
        'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
        'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
        'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_start.setOnClickListener() {
            var firstName: String = et_first.text.toString()
            var secondName: String = et_second.text.toString()
            tv_result.text = sumName(firstName, secondName)
        }

    }

    fun sumName(firstName: String, secondName: String): String {
        val result = conversionWordToNumber(firstName) + conversionWordToNumber(secondName)
        if(result == 0) return "Значения не найдены"
        return "$firstName + $secondName = $result"
    }

    fun conversionWordToNumber(value: String): Int {
        var result = 0
        val newArray = value.toLowerCase().toCharArray()
        for (i in newArray.indices) {
            for (j in array.indices) {
                if (newArray[i] == array[j]) {
                    result += j + 1
                    break
                }
            }
        }
        return result
    }
}