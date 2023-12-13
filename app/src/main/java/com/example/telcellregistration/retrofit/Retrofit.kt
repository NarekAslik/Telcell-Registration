package com.example.telcellregistration.retrofit

import com.example.telcellregistration.`interface`.API
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    val retrofit: Retrofit by lazy {
        val builder = OkHttpClient.Builder()
        builder.hostnameVerifier { _, _ -> true }

        Retrofit.Builder()
            .baseUrl("https://www.jsonkeeper.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
    val api: API by lazy {
        retrofit.create(API::class.java)
    }
}