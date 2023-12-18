package com.example.telcellregistration.`interface`


import com.example.telcellregistration.dataclasses.BonusItems
import com.example.telcellregistration.dataclasses.Items
import retrofit2.Response
import retrofit2.http.GET

interface API {
    @GET("b/HKD8")
    suspend fun getItems(): Response<Items>

    @GET("b/JK75")
    suspend fun getItemsForBonus(): Response<BonusItems>
}