package com.example.smishlyaevakatya_navigation.ui.homework27

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smishlyaevakatya_navigation.ui.homework27.api.provideApi
import com.example.smishlyaevakatya_navigation.ui.homework27.model.Facts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactsViewModel : ViewModel() {

    val result = MutableLiveData<List<Facts>>()

    init {
        getResult()
    }

    private fun getResult() {
        provideApi().getFacts()
            .enqueue(object : Callback<List<Facts>> {
                override fun onResponse(call: Call<List<Facts>>, response: Response<List<Facts>>) {
                    if (response.isSuccessful) {
                        val resp = response.body()
                        result.value = resp
                    }
                }

                override fun onFailure(call: Call<List<Facts>>, t: Throwable) {
                    Log.e("FactsViewModel", t.message.toString())
                }
            })
    }
}