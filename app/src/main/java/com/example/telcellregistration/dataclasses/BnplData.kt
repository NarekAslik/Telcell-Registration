package com.example.telcellregistration.dataclasses

import com.example.telcellregistration.enums.HomeItemsEnums
import com.example.telcellregistration.interfaces.HomeItems

data class BnplData(
    val header: String,
    val message: String,
    val text: String,
    val image: Int
) : HomeItems {
    override fun viewType(): Int {
       return HomeItemsEnums.BNPL_DATA.ordinal
    }
}
