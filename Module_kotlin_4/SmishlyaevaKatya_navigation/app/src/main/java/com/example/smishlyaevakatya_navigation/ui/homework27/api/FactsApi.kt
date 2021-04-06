package com.example.smishlyaevakatya_navigation.ui.homework27.api

import com.example.smishlyaevakatya_navigation.ui.homework27.model.Facts
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface FactsApi {

    @GET("/facts")
    fun getFacts(): Call<List<Facts>>

}

internal fun provideApi(): FactsApi {
    val baseUrl = "https://cat-fact.herokuapp.com"
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
    return retrofit.create(FactsApi::class.java)
}