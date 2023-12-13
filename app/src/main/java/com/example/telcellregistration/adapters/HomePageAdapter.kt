package com.example.telcellregistration.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.*
import com.example.telcellregistration.dataclasses.*
import com.example.telcellregistration.enums.HomeItemsEnums
import com.example.telcellregistration.holders.*
import com.example.telcellregistration.interfaces.HomeItemClickListener
import com.example.telcellregistration.interfaces.HomeItems

@Suppress("UNCHECKED_CAST")
class HomePageAdapter : RecyclerView.Adapter<ViewHolder>() {
    private var homeItemClickListener: HomeItemClickListener? = null
    private var homeItemsList = ArrayList<HomeItems>()

    override fun getItemViewType(position: Int): Int {
        return homeItemsList[position].viewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            HomeItemsEnums.BNPL_DATA.ordinal -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.bnpl_view, parent, false)
                BnplHolder(BnplViewBinding.bind(view))
            }
            HomeItemsEnums.MY_BALANCE_DATA.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.balance_view, parent, false)
                MyBalanceHolder(BalanceViewBinding.bind(view))
            }
            HomeItemsEnums.BANNERS_LIST_DATA.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.banners_layout, parent, false)
                BannerListViewHolder(BannersLayoutBinding.bind(view))
            }
            HomeItemsEnums.SERVICES_LIST_DATA.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.services_layout, parent, false)
                ServicesListViewHolder(ServicesLayoutBinding.bind(view))
            }
            HomeItemsEnums.CHOSEN_PAYMENT_DATA.ordinal -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.chosen_view, parent, false)
                ChosenPaymentViewHolder(ChosenViewBinding.bind(view))
            }
            HomeItemsEnums.HISTORY_LIST_DATA.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.history_layout, parent, false)
                HistoryListViewHolder(HistoryLayoutBinding.bind(view))
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.special_offers_layout, parent, false)
                SpecialOffersViewHolder(SpecialOffersLayoutBinding.bind(view))
            }

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = homeItemsList[position]

        when (item.viewType()) {
            HomeItemsEnums.BNPL_DATA.ordinal -> {
                val myHolder = holder as BnplHolder
                myHolder.bind(item as BnplData)
                myHolder.setBnplClick(homeItemClickListener)
            }
            HomeItemsEnums.MY_BALANCE_DATA.ordinal -> {
                val myBalanceHolder = holder as MyBalanceHolder
                myBalanceHolder.bind(item as MyBalanceData)
                myBalanceHolder.setEyeIconClickListener(homeItemClickListener)
            }
            HomeItemsEnums.BANNERS_LIST_DATA.ordinal -> {
                val myBannerListHolder = holder as BannerListViewHolder
                myBannerListHolder.bind(item as BannersData)
                myBannerListHolder.setBannerItemClickListener(homeItemClickListener)
            }
            HomeItemsEnums.SERVICES_LIST_DATA.ordinal -> {
                val myServiceListHolder = holder as ServicesListViewHolder
                myServiceListHolder.bind(item as ServicesData)
                myServiceListHolder.setServiceItemClickListener(homeItemClickListener)
            }
            HomeItemsEnums.HISTORY_LIST_DATA.ordinal -> {
                val myHistoryListViewHolder = holder as HistoryListViewHolder
                myHistoryListViewHolder.bind(item as HistoriesData)
                myHistoryListViewHolder.setHistoryItemClickListener(homeItemClickListener)
            }
            HomeItemsEnums.SPECIAL_OFFERS_LIST_DATA.ordinal -> {
                val mySpecialOffersViewHolder = holder as SpecialOffersViewHolder
                mySpecialOffersViewHolder.bind(item as SpecialOffersData)
                mySpecialOffersViewHolder.setSpecialOfferItemClickListener(homeItemClickListener)
            }
            HomeItemsEnums.CHOSEN_PAYMENT_DATA.ordinal -> {
                val myChosenPaymentViewHolder = holder as ChosenPaymentViewHolder
                myChosenPaymentViewHolder.bind(item as ChosenPaymentData)
            }

        }
    }

    override fun getItemCount(): Int = homeItemsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setHomeItemsList(list: List<HomeItems>) {
        homeItemsList = arrayListOf()
        homeItemsList.addAll(list)
        notifyDataSetChanged()
    }

    fun setBannerItemClickListener(listener: HomeItemClickListener) {
        homeItemClickListener = listener
    }

    fun setBnplItemClickListener(listener: HomeItemClickListener) {
        homeItemClickListener = listener
    }

    fun setEyeIconClickListener(listener: HomeItemClickListener) {
        homeItemClickListener = listener
    }

    fun setServiceItemClickListener(listener: HomeItemClickListener) {
        homeItemClickListener = listener
    }

    fun setHistoryItemClickListener(listener: HomeItemClickListener) {
        homeItemClickListener = listener
    }

    fun setSpecialOfferItemClickListener(listener: HomeItemClickListener) {
        homeItemClickListener = listener
    }
}