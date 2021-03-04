package com.example.smishlyaevakatya_android.homework20.lifecycle_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.smishlyaevakatya_android.MainActivity
import com.example.smishlyaevakatya_android.R
import com.example.smishlyaevakatya_android.homework20.lifecycle.MyServerActivity
import com.example.smishlyaevakatya_android.homework20.view_model.MySecondActivity
import kotlinx.android.synthetic.main.activity_my.*

class MyActivity : AppCompatActivity() {

    private val tag = "MyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
//        finish()
        Log.i(tag, "onCreate")

        val valueSecond = MySecondFragment()
        val valueServer = ServerFragment()
        val valueModel = ModelFragment()


        btn_start_onCreate.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, valueSecond)
                .addToBackStack(null)
                .commit()
        }

        btn_start_lifecycle.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, valueServer)
                .addToBackStack(null)
                .commit()
        }

        btn_start_view_model.setOnClickListener {
            val intent = Intent(this, MySecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(tag, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "onDestroy")
    }
}