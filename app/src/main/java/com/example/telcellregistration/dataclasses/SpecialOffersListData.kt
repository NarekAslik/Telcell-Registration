package com.example.telcellregistration.dataclasses

import com.example.telcellregistration.enums.HomeItemsEnums
import com.example.telcellregistration.interfaces.HomeItems

data class SpecialOffersData(
    val specialOfferList: List<SpecialOfferData>
) : HomeItems {
    override fun viewType(): Int {
        return HomeItemsEnums.SPECIAL_OFFERS_LIST_DATA.ordinal
    }
}

data class SpecialOfferData(
    val imageView: String,
    val textView: String
)