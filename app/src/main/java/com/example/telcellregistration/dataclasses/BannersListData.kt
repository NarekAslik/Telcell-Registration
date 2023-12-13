package com.example.telcellregistration.dataclasses

import com.example.telcellregistration.enums.HomeItemsEnums
import com.example.telcellregistration.interfaces.HomeItems

data class BannersListData(
    val bannersList: List<BannerData>
) : HomeItems {
    override fun viewType(): Int {
        return HomeItemsEnums.BANNERS_LIST_DATA.ordinal
    }
}

data class BannerData(
    val bannerText: String,
    val bannerImage: String,
)
