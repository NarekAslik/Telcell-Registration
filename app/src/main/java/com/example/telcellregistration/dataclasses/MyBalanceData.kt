package com.example.telcellregistration.dataclasses

import com.example.telcellregistration.enums.HomeItemsEnums
import com.example.telcellregistration.interfaces.HomeItems

data class MyBalanceData(
    val balance: String
) : HomeItems {
    override fun viewType(): Int {
      return HomeItemsEnums.MY_BALANCE_DATA.ordinal
    }
}
