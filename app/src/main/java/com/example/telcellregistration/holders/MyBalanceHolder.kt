package com.example.telcellregistration.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.telcellregistration.databinding.BalanceViewBinding
import com.example.telcellregistration.dataclasses.MyBalanceData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class MyBalanceHolder(private val binding: BalanceViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private var homeItemClickListener: HomeItemClickListener? = null
    fun bind(myBalanceData: MyBalanceData) {
        binding.apply {
            balance.text = myBalanceData.balance
            eyeIcon.setOnClickListener {
                homeItemClickListener?.eyeIconClick(myBalanceData)
            }
        }
    }

    fun setEyeIconClickListener(listener: HomeItemClickListener?) {
        homeItemClickListener = listener
    }
}