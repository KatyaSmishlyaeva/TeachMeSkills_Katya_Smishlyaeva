package com.example.coursewidjet.homework31

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursewidjet.homework31.api.provideApi
import com.example.coursewidjet.homework31.model.CourseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseViewModel : ViewModel() {

    val allCourse = MutableLiveData<List<CourseItem>>()

    init {
        getResult()
    }

    private fun getResult() {
        provideApi().getCourse()
            .enqueue(object : Callback<List<CourseItem>> {
                override fun onResponse(
                    call: Call<List<CourseItem>>,
                    response: Response<List<CourseItem>>
                ) {
                    if (response.isSuccessful) {
                        val resp = response.body()
                        allCourse.value = resp
                    }
                }

                override fun onFailure(call: Call<List<CourseItem>>, t: Throwable) {
                    Log.e("FactsViewModel", t.message.toString())
                }
            })
    }
}