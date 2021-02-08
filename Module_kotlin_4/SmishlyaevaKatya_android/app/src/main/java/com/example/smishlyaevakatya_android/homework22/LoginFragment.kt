package com.example.smishlyaevakatya_android.homework22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.smishlyaevakatya_android.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_sing_in.setOnClickListener() {
            val login = et_login.text.toString()
            val password = et_password.text.toString()
            if (login.isEmpty() || password.isEmpty()) {
                showToast("Одно или два поля пустые")
            } else if (isEmailValid(login) && isPasswordValid(password)) {
                showToast("Данные валидные")
                val sign_in = CheckBoxFragment()
                val mainActivity = activity as? LoginActivity
                mainActivity?.startNewFragment(sign_in)
            } else {
                showToast("Данные не валидные")
            }
        }
    }

    private fun isEmailValid(login: String): Boolean {
        return (login.contains('@') && login.contains('.') && login.length > 6)
    }

    private fun isPasswordValid(password: String): Boolean {
        return (password.length in 8..14)
    }

    private fun showToast(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }
}