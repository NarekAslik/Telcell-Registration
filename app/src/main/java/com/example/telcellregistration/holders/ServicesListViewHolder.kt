package com.example.telcellregistration.holders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telcellregistration.adapters.ServicesAdapter
import com.example.telcellregistration.databinding.ServicesLayoutBinding
import com.example.telcellregistration.dataclasses.ServicesListData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class ServicesListViewHolder(val binding: ServicesLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val servicesAdapter = ServicesAdapter()
    fun bind(servicesListData: ServicesListData) {
        binding.servicesRcView.apply {
            adapter = servicesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        servicesAdapter.setServicesList(servicesListData.servicesList)
    }

    fun setServiceItemClickListener(listener: HomeItemClickListener?) {
        servicesAdapter.setServiceItemClickListener(listener)
    }
}