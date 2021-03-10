package com.example.contactcontentprovider

import android.Manifest
import android.content.Intent
import androidx.core.app.ActivityCompat;
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE_READ_CONTACTS = 1

    var cols = listOf<String>(
        ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY,
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    ).toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_add_contact)
        button.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                Array(1) { Manifest.permission.READ_CONTACTS },
                REQUEST_CODE_READ_CONTACTS
            )
        } else
            readContact()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_READ_CONTACTS && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            readContact()
    }

    private fun readContact() {
        val listView = findViewById<ListView>(R.id.listView1)
        val searchView = findViewById<SearchView>(R.id.searchView)

        var from = listOf<String>(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        ).toTypedArray()

        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val rs = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols, null, null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )

        val adapter = SimpleCursorAdapter(
            this, android.R.layout.simple_list_item_2,
            rs, from, to, 0
        )
        listView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                var rs = contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    cols, "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
                    Array(1) { "%$newText%" },
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                )
                adapter.changeCursor(rs)
                return false
            }
        })

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                var lookupKeyIndex = 0

                var idIndex = 0

                var currentLookupKey: String? = null

                var currentId: Long = 0

                var selectedContactUri: Uri? = null

                rs?.apply {
                    lookupKeyIndex = getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY)

                    currentLookupKey = getString(lookupKeyIndex)

                    idIndex = getColumnIndex(ContactsContract.Contacts._ID)

                    currentId = getLong(idIndex)

                    selectedContactUri =
                        ContactsContract.Contacts.getLookupUri(currentId, currentLookupKey)
                }

                val editIntent = Intent(Intent.ACTION_EDIT).apply {
                    setDataAndType(selectedContactUri, ContactsContract.Contacts.CONTENT_ITEM_TYPE)
                    putExtra("finishActivityOnSaveCompleted", true)
                }

                startActivity(editIntent)
            }
        }
    }

    /*
    * Refresh our listView after changing the contact
    * */
    override fun onResume() {
        super.onResume()
        readContact()
    }
}