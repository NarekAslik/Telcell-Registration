package com.example.telcellregistration.dataclasses

import com.example.telcellregistration.enums.HomeItemsEnums
import com.example.telcellregistration.interfaces.HomeItems

data class ChosenPaymentData(
    val isCopied: Boolean
) : HomeItems {
    override fun viewType(): Int {
        return HomeItemsEnums.CHOSEN_PAYMENT_DATA.ordinal
    }
}
