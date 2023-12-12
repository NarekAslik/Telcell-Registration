package com.example.telcellregistration.holders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telcellregistration.adapters.BannerAdapter
import com.example.telcellregistration.databinding.BannersLayoutBinding
import com.example.telcellregistration.dataclasses.BannersListData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class BannerListViewHolder(val binding: BannersLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val bannerAdapter = BannerAdapter()
    fun bind(bannerListData: BannersListData) {
        binding.bannersRcView.apply {
            adapter = bannerAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        bannerAdapter.setBannersList(bannerListData.bannersList)
    }

    fun setBannerItemClickListener(listener: HomeItemClickListener?) {
        bannerAdapter.setBannerItemClickListener(listener)
    }

}