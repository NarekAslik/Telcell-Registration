package com.example.telcellregistration.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.HistoryItemBinding
import com.example.telcellregistration.dataclasses.HistoryData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class HistoryItemsAdapter : RecyclerView.Adapter<HistoryItemsAdapter.HistoryItemsHolder>() {
    private var homeItemClickListener: HomeItemClickListener? = null
    private var historyItemsList = ArrayList<HistoryData>()

    class HistoryItemsHolder(val binding: HistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        return HistoryItemsHolder(HistoryItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: HistoryItemsHolder, position: Int) {
        val data = historyItemsList[position]
        holder.binding.apply {
            Glide.with(historyIconImView)
                .load(data.icon)
                .centerCrop()
                .into(historyIconImView)
            historyActionTvView.text = data.actionNameText
            toActionIdTvView.text = data.toActionId
            amountTvView.text = data.amountText
            approvedTvView.text = data.isApproved.toString()
            holder.itemView.setOnClickListener {
                homeItemClickListener?.historyItemClick(data)
            }
        }

    }

    override fun getItemCount(): Int = historyItemsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setHistoryItemsList(list: List<HistoryData>) {
        historyItemsList = arrayListOf()
        historyItemsList.addAll(list)
        notifyDataSetChanged()
    }

    fun setHistoryItemClickListener(listener: HomeItemClickListener?) {
        homeItemClickListener = listener
    }
}