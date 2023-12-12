package com.example.telcellregistration.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.BannerItemBinding
import com.example.telcellregistration.dataclasses.BannerData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class BannerAdapter : RecyclerView.Adapter<BannerAdapter.BannerHolder>() {

    private var homeItemClickListener: HomeItemClickListener? = null

    private var bannersList = ArrayList<BannerData>()

    class BannerHolder(val binding: BannerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
        return BannerHolder(BannerItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        val data = bannersList[position]
        holder.binding.apply {
            Glide.with(bannerImView)
                .load(data.bannerImage)
                .into(bannerImView)
            bannerTvView.text = data.bannerText
            holder.itemView.setOnClickListener {
                homeItemClickListener?.bannerItemClick(data)
            }
        }
    }

    override fun getItemCount(): Int = bannersList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setBannersList(list: List<BannerData>) {
        bannersList = arrayListOf()
        bannersList.addAll(list)
        notifyDataSetChanged()
    }

    fun setBannerItemClickListener(listener: HomeItemClickListener?) {
        homeItemClickListener = listener
    }
}