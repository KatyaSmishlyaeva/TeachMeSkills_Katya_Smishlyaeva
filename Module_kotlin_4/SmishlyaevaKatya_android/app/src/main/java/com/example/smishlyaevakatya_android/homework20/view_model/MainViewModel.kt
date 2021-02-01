package com.example.smishlyaevakatya_android.homework20.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val age = MutableLiveData<Int>()
    val name = MutableLiveData<String>()

    fun setup() {
        val apiFirstName = "Ivan"
        val apiLastName = "Ivanov"
        val apiAge = 30
        firstName.value = apiFirstName
        lastName.value = apiLastName
        age.value = apiAge
        val apiName = "Ivanov\nIvan\n30"
        name.value = apiName
    }
}