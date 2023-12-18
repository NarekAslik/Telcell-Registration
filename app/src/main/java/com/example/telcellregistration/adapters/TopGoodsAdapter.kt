package com.example.telcellregistration.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.BonusPageVerticalItemBinding
import com.example.telcellregistration.dataclasses.BonusTopGoodsData

class TopGoodsAdapter : RecyclerView.Adapter<TopGoodsAdapter.TopGoodsHolder>() {
    private var topGoodsList = ArrayList<BonusTopGoodsData>()

    class TopGoodsHolder(val binding: BonusPageVerticalItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopGoodsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bonus_page_vertical_item, parent, false)
        return TopGoodsHolder(BonusPageVerticalItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: TopGoodsHolder, position: Int) {
        val data = topGoodsList[position]
        holder.binding.apply {
            Glide.with(productPicture)
                .load(data.productPicture)
                .centerCrop()
                .into(productPicture)
            Glide.with(bonusPicture)
                .load(data.bonusPicture)
                .centerCrop()
                .into(bonusPicture)
            productNameTvView.text = data.productName
            productOwnerTvView.text = data.productOwner
            aboutBonusesTvView.text = data.bonusesInfo
            productTermTvView.text = data.productTerm
            productCountProgress.progress = data.progressInfo
            countTvView.text = data.count
            productValue.text = data.productValue
        }
    }

    override fun getItemCount() = topGoodsList.size

    fun setTopGoodsList(list: List<BonusTopGoodsData>) {
        topGoodsList = arrayListOf()
        topGoodsList.addAll(list)
        notifyDataSetChanged()
    }
}