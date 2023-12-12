package com.example.telcellregistration.interfaces

import com.example.telcellregistration.dataclasses.*

interface HomeItemClickListener {
    fun bannerItemClick(bannerData: BannerData)
    fun bnplItemClick(bnplData: BnplData)
    fun eyeIconClick(balanceData: MyBalanceData)
    fun serviceItemClick(servicesData: ServicesData)
    fun historyItemClick(historyData: HistoryData)
    fun specialOfferItemClick(specialOfferData: SpecialOfferData)
}