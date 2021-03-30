package com.example.coursewidjet.homework31.api

import com.example.coursewidjet.homework31.model.CourseItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface CourseApi {

    @GET("rates?periodicity=0")
    fun getCourse(): Call<List<CourseItem>>
}

internal fun provideApi(): CourseApi {
    val baseUrl = "https://www.nbrb.by/api/exrates/"
    val loginInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loginInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(CourseApi::class.java)
}