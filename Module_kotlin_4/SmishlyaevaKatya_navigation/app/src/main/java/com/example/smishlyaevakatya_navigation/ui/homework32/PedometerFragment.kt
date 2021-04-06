package com.example.smishlyaevakatya_navigation.ui.homework32

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.smishlyaevakatya_navigation.R
import kotlinx.android.synthetic.main.fragment_pedometer.*

class PedometerFragment : Fragment(), SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var isRunning = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    private lateinit var tvSteps: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pedometer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvSteps = view.findViewById(R.id.tv_steps)
        loadData()
        resetSteps()
        sensorManager = context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        isRunning = true
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if (stepSensor == null) {
            Toast.makeText(context, "Нет сенсора", Toast.LENGTH_LONG).show()
        } else {
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (isRunning) {
            totalSteps = event.values[0]
            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
            tvSteps.text = ("$currentSteps")

            progress_circular.apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    private fun resetSteps() {
        tvSteps.setOnClickListener {
            Toast.makeText(context, "Нажмите и удержите для сброса", Toast.LENGTH_LONG).show()
        }
        tvSteps.setOnLongClickListener {
            previousTotalSteps = totalSteps
            tv_steps.text = 0.toString()
            saveData()
            true
        }
    }

    private fun saveData() {
        val sharedPreferences = context?.getSharedPreferences("Preference", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putFloat("key1", previousTotalSteps)
        editor?.apply()
    }

    private fun loadData() {
        val sharedPreferences = context?.getSharedPreferences("Preference", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences?.getFloat("key1", 0f)
        if (savedNumber != null) {
            previousTotalSteps = savedNumber
        }
    }
}