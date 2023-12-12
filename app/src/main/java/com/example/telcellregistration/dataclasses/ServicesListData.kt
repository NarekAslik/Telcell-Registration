package com.example.telcellregistration.dataclasses

import com.example.telcellregistration.enums.HomeItemsEnums
import com.example.telcellregistration.interfaces.HomeItems

data class ServicesListData(
    val servicesList: List<ServicesData>
) : HomeItems {
    override fun viewType(): Int {
       return HomeItemsEnums.SERVICES_LIST_DATA.ordinal
    }
}

data class ServicesData(
    val serviceIcon: Int,
    val serviceText: String
)