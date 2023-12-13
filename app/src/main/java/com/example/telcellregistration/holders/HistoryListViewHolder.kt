package com.example.telcellregistration.holders

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telcellregistration.adapters.HistoryItemsAdapter
import com.example.telcellregistration.databinding.HistoryLayoutBinding
import com.example.telcellregistration.dataclasses.HistoriesData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class HistoryListViewHolder(val binding: HistoryLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val historyListAdapter = HistoryItemsAdapter()
    fun bind(historyList: HistoriesData) {
        binding.historyRecycler.apply {
            adapter = historyListAdapter
            layoutManager = GridLayoutManager(context, 1)
        }
        historyListAdapter.setHistoryItemsList(historyList.historyListData)
    }

    fun setHistoryItemClickListener(listener: HomeItemClickListener?) {
        historyListAdapter.setHistoryItemClickListener(listener)
    }
}