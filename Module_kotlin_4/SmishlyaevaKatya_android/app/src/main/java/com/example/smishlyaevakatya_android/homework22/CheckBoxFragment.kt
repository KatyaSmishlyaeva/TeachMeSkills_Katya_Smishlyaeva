package com.example.smishlyaevakatya_android.homework22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.smishlyaevakatya_android.R
import kotlinx.android.synthetic.main.fragment_checkbox.*

class CheckBoxFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checkbox, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cb_mail.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) showToast("e-mail is checked")
        }

        cb_name.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) showToast("name is checked")
        }

        cb_surname.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) showToast("surname is checked")
        }

        cb_date.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) showToast("date is checked")
        }
    }

    private fun showToast(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }
}