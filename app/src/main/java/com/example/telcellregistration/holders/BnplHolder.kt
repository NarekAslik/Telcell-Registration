package com.example.telcellregistration.holders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.telcellregistration.databinding.BnplViewBinding
import com.example.telcellregistration.dataclasses.BnplData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class BnplHolder(private val binding: BnplViewBinding) : RecyclerView.ViewHolder(binding.root) {
    private var bnplClickListener: HomeItemClickListener? = null
    fun bind(bnplData: BnplData) {
        binding.apply {
            Glide.with(visaImage)
                .load(bnplData.image)
                .centerCrop()
                .into(visaImage)
            visaCardInfo.text = bnplData.text
            headerTvView.text = bnplData.header
            messageTvView.text = bnplData.message
            itemView.setOnClickListener {
                bnplClickListener?.bnplItemClick(bnplData)
            }
        }
    }

    fun setBnplClick(listener: HomeItemClickListener?) {
        bnplClickListener = listener
    }

}