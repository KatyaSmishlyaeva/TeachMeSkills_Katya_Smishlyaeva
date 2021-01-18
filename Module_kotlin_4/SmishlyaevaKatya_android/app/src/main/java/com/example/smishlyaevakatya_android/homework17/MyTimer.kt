package com.example.smishlyaevakatya_android.homework17

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.smishlyaevakatya_android.R
import kotlinx.android.synthetic.main.activity_timer.*

class MyTimer : AppCompatActivity() {
    val secondsInMilli: Long = 1000
    val minutesInMilli = 60000
    val hoursInMilli = 60000000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        btn_back.setOnClickListener {
            this.onBackPressed()
        }

        btn_start.setOnClickListener {
            btn_start.isClickable = false
            val userTime = et_time.text.toString()
            if (userTime.isEmpty()) {
                tv_time.text = "Введите время"
                btn_start.isClickable = true
            } else {
                val userTimerMillis = userTime.toLong() * 60 * 1000
                val timer = object : CountDownTimer(userTimerMillis, 1000) {

                    override fun onTick(millisUntilFinished: Long) {
                        var currentTime = millisUntilFinished

                        val hoursUntilFinished = currentTime / hoursInMilli
                        currentTime %= hoursInMilli

                        val minutesUntilFinished = currentTime / minutesInMilli
                        currentTime %= minutesInMilli

                        val secondsUntilFinished = currentTime / secondsInMilli

                        tv_time.text =
                            "$hoursUntilFinished:$minutesUntilFinished:$secondsUntilFinished"
                    }

                    override fun onFinish() {
                        tv_time.text = "00:00:00"
                        et_time.text = null
                        btn_start.isClickable = true
                    }
                }
                btn_reset.setOnClickListener {
                    timer.cancel()
                    tv_time.text = "00:00:00"
                    et_time.text = null
                    btn_start.isClickable = true
                }
                timer.start()
            }
        }
    }
}
