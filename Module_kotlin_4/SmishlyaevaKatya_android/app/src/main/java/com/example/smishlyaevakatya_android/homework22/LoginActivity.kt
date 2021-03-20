package com.example.smishlyaevakatya_android.homework22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.smishlyaevakatya_android.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_back_login.setOnClickListener {
            this.onBackPressed()
        }

        val value = LoginFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fr_container, value)
            .addToBackStack(null)
            .commit()
    }

    fun startNewFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}