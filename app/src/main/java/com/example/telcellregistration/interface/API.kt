package com.example.telcellregistration.`interface`


import com.example.telcellregistration.dataclasses.Items
import retrofit2.Response
import retrofit2.http.GET

interface API {
    @GET("b/UW8M")
    suspend fun getItems(): Response<Items>
}