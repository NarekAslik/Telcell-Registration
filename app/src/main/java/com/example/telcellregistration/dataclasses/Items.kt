package com.example.telcellregistration.dataclasses

data class Items(
    val bnplData: BnplData,
    val balanceData: MyBalanceData,
    val bannersData: BannersData,
    val servicesData: ServicesData,
    val chosenPaymentData: ChosenPaymentData,
    val historiesData: HistoriesData,
    val specialOffersData: SpecialOffersData
)
