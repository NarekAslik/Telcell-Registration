package com.example.telcellregistration.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.SpecialOfferItemBinding
import com.example.telcellregistration.dataclasses.SpecialOfferData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class SpecialOffersAdapter : RecyclerView.Adapter<SpecialOffersAdapter.SpecialOffersHolder>() {
    private var homeItemClickListener: HomeItemClickListener? = null
    private var specialOffersList = ArrayList<SpecialOfferData>()

    class SpecialOffersHolder(val binding: SpecialOfferItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialOffersHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.special_offer_item, parent, false)
        return SpecialOffersHolder(SpecialOfferItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: SpecialOffersHolder, position: Int) {
        val data = specialOffersList[position]
        holder.binding.apply {
            Glide.with(discountImView)
                .load(data.imageView)
                .into(discountImView)
            discountInfoTvView.text = data.textView
            holder.itemView.setOnClickListener {
                homeItemClickListener?.specialOfferItemClick(data)
            }
        }
    }

    override fun getItemCount(): Int = specialOffersList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setSpecialOffersList(list: List<SpecialOfferData>) {
        specialOffersList = arrayListOf()
        specialOffersList.addAll(list)
        notifyDataSetChanged()
    }
    fun setSpecialOfferItemClickListener(listener:HomeItemClickListener?){
        homeItemClickListener=listener
    }
}