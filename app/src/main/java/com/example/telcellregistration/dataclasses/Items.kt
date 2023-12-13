package com.example.telcellregistration.dataclasses

data class Items(
    val bnplData: BnplData,
    val balanceData: MyBalanceData,
    val bannersListData: BannersListData,
    val servicesListData: ServicesListData,
    val chosenPaymentData: ChosenPaymentData,
    val historyListData: HistoryListData,
    val specialOfferListData: SpecialOfferListData
)
