package com.example.telcellregistration.dataclasses

import com.example.telcellregistration.enums.HomeItemsEnums
import com.example.telcellregistration.interfaces.HomeItems

data class ServicesData(
    val servicesList: List<ServiceData>
) : HomeItems {
    override fun viewType(): Int {
       return HomeItemsEnums.SERVICES_LIST_DATA.ordinal
    }
}

data class ServiceData(
    val serviceIcon: String,
    val serviceText: String
)