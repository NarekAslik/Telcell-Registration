package com.example.telcellregistration.repository

import com.example.telcellregistration.dataclasses.BonusItems
import com.example.telcellregistration.retrofit.Retrofit
import retrofit2.Response
import com.example.telcellregistration.dataclasses.Items

class Repository {

    private val service = Retrofit.api

    suspend fun getItems(): Response<Items> {
        return service.getItems()
    }

    suspend fun getItemsForBonus(): Response<BonusItems> {
        return service.getItemsForBonus()
    }

    companion object {
        fun newInstance(): Repository {
            return Repository()
        }
    }
}