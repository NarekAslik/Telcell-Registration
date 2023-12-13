package com.example.telcellregistration.viewmodel


import androidx.lifecycle.ViewModel
import com.example.telcellregistration.R
import com.example.telcellregistration.dataclasses.*
import com.example.telcellregistration.interfaces.HomeItems


class HomeViewModel() : ViewModel() {

    fun getHomeItemsList(): List<HomeItems> {

        val homeList = arrayListOf<HomeItems>()

//        homeList.add(getBnplData())
//        homeList.add(getMyBalanceData())
//        homeList.add(getBannersList())
//        homeList.add(getServiceList())
//        homeList.add(getChosenPaymentData())
//        homeList.add(getHistoryList())
//        homeList.add(getSpecialOffersList())



        return homeList
    }

//    private fun getBannersList(): BannersListData {
//        val bannersList = arrayListOf(
//            BannerData(
//                "Ուղետոմսեր",
//                R.drawable.bus_ticket_image
//            ),
//            BannerData(
//                "Խաղարկություն",
//                R.drawable.phone_lottery_image
//            ),
//            BannerData(
//                "Խաղարկություն",
//                R.drawable.phone_lottery_image
//            ),
//            BannerData(
//                "Խաղարկություն",
//                R.drawable.phone_lottery_image
//            ),
//            BannerData(
//                "Խաղարկություն",
//                R.drawable.phone_lottery_image
//            ),
//            BannerData(
//                "Խաղարկություն",
//                R.drawable.phone_lottery_image
//            ),
//            BannerData(
//                "Խաղարկություն",
//                R.drawable.phone_lottery_image
//            )
//        )
//        return BannersListData(bannersList)
//    }
//
//    private fun getHistoryList(): HistoryListData {
//        val historyList = arrayListOf(
//            HistoryData(
//                R.drawable.top_up_icon,
//                "քարտի համալրում",
//                "431829**7905",
//                "+8000 AMD",
//                true
//            ),
//            HistoryData(
//                R.drawable.top_up_icon,
//                "քարտի համալրում",
//                "431829**7905",
//                "+8000 AMD",
//                true
//            ),
//            HistoryData(
//                R.drawable.top_up_icon,
//                "քարտի համալրում",
//                "431829**7905",
//                "+8000 AMD",
//                true
//            ),
//            HistoryData(
//                R.drawable.top_up_icon,
//                "քարտի համալրում",
//                "431829**7905",
//                "+8000 AMD",
//                true
//            ),
//        )
//        return HistoryListData(historyList)
//    }
//
//    private fun getServiceList(): ServicesListData {
//        val servicesList = arrayListOf(
//            ServicesData(
//                R.drawable.transport_icon,
//                "Տրանսպորտ"
//            ),
//            ServicesData(
//                R.drawable.transport_icon,
//                "Տրանսպորտ"
//            ),
//            ServicesData(
//                R.drawable.transport_icon,
//                "Տրանսպորտ"
//            ),
//            ServicesData(
//                R.drawable.transport_icon,
//                "Տրանսպորտ"
//            ),
//            ServicesData(
//                R.drawable.transport_icon,
//                "Տրանսպորտ"
//            ),
//            ServicesData(
//                R.drawable.transport_icon,
//                "Տրանսպորտ"
//            ),
//        )
//        return ServicesListData(servicesList)
//    }
//
//    private fun getSpecialOffersList(): SpecialOfferListData {
//        val specialOffersList = arrayListOf(
//            SpecialOfferData(
//                R.drawable.discount_image,
//                "20 % ԶԵՂՉ"
//            ),
//            SpecialOfferData(
//                R.drawable.discount_image,
//                "20 % ԶԵՂՉ"
//            ),
//            SpecialOfferData(
//                R.drawable.discount_image,
//                "20 % ԶԵՂՉ"
//            ),
//            SpecialOfferData(
//                R.drawable.discount_image,
//                "20 % ԶԵՂՉ"
//            ),
//            SpecialOfferData(
//                R.drawable.discount_image,
//                "20 % ԶԵՂՉ"
//            ),
//            SpecialOfferData(
//                R.drawable.discount_image,
//                "20 % ԶԵՂՉ"
//            ),
//        )
//        return SpecialOfferListData(specialOffersList)
//    }

    private fun getBnplData(): BnplData {
        return BnplData(
            "Վճարիր հետո",
            "Գնիր հիմա վճարիր մաս-մաս աոանց % մինչև 1 400 000",
            "Ստացիր 3% դեպոզիտ անվճար VISA քարտով",
            R.drawable.visa_card_picture
        )
    }

    private fun getMyBalanceData(): MyBalanceData {
        return MyBalanceData(
            "1000"
        )
    }

    private fun getChosenPaymentData(): ChosenPaymentData {
        return ChosenPaymentData(
            true
        )
    }
}