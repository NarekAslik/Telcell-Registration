package com.example.telcellregistration

import com.example.telcellregistration.retrofit.Retrofit
import retrofit2.Response
import com.example.telcellregistration.dataclasses.Items

class Repository {

    private val service = Retrofit.api

    suspend fun getItems():Response<Items>{
        return service.getItems()
    }
    companion object
}