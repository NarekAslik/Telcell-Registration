package com.example.telcellregistration.holders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telcellregistration.adapters.SpecialOffersAdapter
import com.example.telcellregistration.databinding.SpecialOffersLayoutBinding
import com.example.telcellregistration.dataclasses.SpecialOfferListData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class SpecialOffersViewHolder(val binding: SpecialOffersLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val specialOffersAdapter = SpecialOffersAdapter()

    fun bind(specialOffersData: SpecialOfferListData) {
        binding.specialOffersRcView.apply {
            adapter = specialOffersAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        specialOffersAdapter.setSpecialOffersList(specialOffersData.specialOfferList)
    }

    fun setSpecialOfferItemClickListener(listener: HomeItemClickListener?) {
        specialOffersAdapter.setSpecialOfferItemClickListener(listener)
    }
}