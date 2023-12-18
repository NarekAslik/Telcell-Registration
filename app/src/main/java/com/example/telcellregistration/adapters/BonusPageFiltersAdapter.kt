package com.example.telcellregistration.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.BonusFragmentBinding
import com.example.telcellregistration.databinding.BonusPageHorizRcViewItemBinding
import com.example.telcellregistration.dataclasses.BonusFiltersData

class BonusPageFiltersAdapter :
    RecyclerView.Adapter<BonusPageFiltersAdapter.BonusPageFiltersHolder>() {

    private var filtersList = ArrayList<BonusFiltersData>()

    class BonusPageFiltersHolder(val binding: BonusPageHorizRcViewItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BonusPageFiltersHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.bonus_page_horiz_rc_view_item, parent, false)
        return BonusPageFiltersHolder(BonusPageHorizRcViewItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: BonusPageFiltersHolder, position: Int) {
        val data = filtersList[position]
        holder.binding.apply {
            Glide.with(horizRcVieItemIcon)
                .load(data.icon)
                .centerCrop()
                .into(horizRcVieItemIcon)
            horizRcViewItemTvView.text = data.text
        }
    }

    override fun getItemCount() = filtersList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setFiltersList(list: List<BonusFiltersData>) {
        filtersList = arrayListOf()
        filtersList.addAll(list)
        notifyDataSetChanged()
    }
}