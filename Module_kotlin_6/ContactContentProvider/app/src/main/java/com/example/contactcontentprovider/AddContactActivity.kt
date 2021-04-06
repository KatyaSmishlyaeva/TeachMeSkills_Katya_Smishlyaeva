package com.example.contactcontentprovider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        val name = findViewById<EditText>(R.id.et_name)
        val phone = findViewById<EditText>(R.id.et_phone)
        val addButton = findViewById<Button>(R.id.btn_add)

        addButton.setOnClickListener {
            if (name.text.toString().isNotEmpty() && phone.text.toString().isNotEmpty()) {
                val intent = Intent(ContactsContract.Intents.Insert.ACTION).apply {
                    type = ContactsContract.RawContacts.CONTENT_TYPE
                }
                intent.apply {
                    putExtra(ContactsContract.Intents.Insert.NAME, name.text.toString())
                    putExtra(ContactsContract.Intents.Insert.PHONE, phone.text)
                }
                startActivity(intent)
                name.text.clear()
                phone.text.clear()

            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            }
        }


    }
}