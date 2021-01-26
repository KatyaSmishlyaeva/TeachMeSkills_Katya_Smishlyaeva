package com.example.smishlyaevakatya_android.homework18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smishlyaevakatya_android.R
import kotlinx.android.synthetic.main.activity_harvesting.*
import kotlinx.coroutines.*

class Harvesting : AppCompatActivity() {

    var countBeetMo = 0
    var countCabbageMo = 0
    var countPotatoMo = 0
    var countBeetGro = 0
    var countCabbageGro = 0
    var countPotatoGro = 0
    var countBeetBro = 0
    var countCabbageBro = 0
    var countPotatoBro = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harvesting)

        btn_back_harvest.setOnClickListener {
            this.onBackPressed()
        }

        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                delay(1000)
                countBeetMo += randomBeet()
                tv_mo_count_beet.text = countBeetMo.toString()
                countCabbageMo += randomCabbage()
                tv_mo_count_cab.text = countCabbageMo.toString()
                countPotatoMo += randomPotato()
                tv_mo_count_pot.text = countPotatoMo.toString()

                countBeetGro += randomBeet()
                tv_gro_count_beet.text = countBeetGro.toString()
                countCabbageGro += randomCabbage()
                tv_gro_count_cab.text = countCabbageGro.toString()
                countPotatoGro += randomPotato()
                tv_gro_count_pot.text = countPotatoGro.toString()

                countBeetBro += randomBeet()
                tv_bro_count_beet.text = countBeetBro.toString()
                countCabbageBro += randomCabbage()
                tv_bro_count_cab.text = countCabbageBro.toString()
                countPotatoBro += randomPotato()
                tv_bro_count_pot.text = countPotatoBro.toString()

                if (countBeetMo >= 100 && countCabbageMo >= 100 && countPotatoMo >= 100) {
                    tv_winner.text = "Победитель - Минская область!"
                    break
                }

                if (countBeetGro >= 100 && countCabbageGro >= 100 && countPotatoGro >= 100) {
                    tv_winner.text = "Победитель - Гродненская область!"
                    break
                }

                if (countBeetBro >= 100 && countCabbageBro >= 100 && countPotatoBro >= 100) {
                    tv_winner.text = "Победитель - Брестская область!"
                    break
                }
            }
        }
    }

    fun randomBeet(): Int {
        return (0..10).random()
    }

    fun randomCabbage(): Int {
        return (0..15).random()
    }

    fun randomPotato(): Int {
        return (0..13).random()
    }
}