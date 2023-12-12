package com.example.telcellregistration.dataclasses

import com.example.telcellregistration.enums.HomeItemsEnums
import com.example.telcellregistration.interfaces.HomeItems

data class HistoryListData(
    val historyListData: List<HistoryData>
) : HomeItems {
    override fun viewType(): Int {
      return HomeItemsEnums.HISTORY_LIST_DATA.ordinal
    }
}

data class HistoryData(
    val icon: Int,
    val actionNameText: String,
    val toActionId: String,
    val amountText: String,
    val isApproved: Boolean
)