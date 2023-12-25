package com.example.telcellregistration.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.CardCloseReasonLayoutBinding

class CardCloseAdapter : RecyclerView.Adapter<CardCloseAdapter.CardCloseHolder>() {
    private var reasonsList = ArrayList<String>()

    class CardCloseHolder(val binding: CardCloseReasonLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardCloseHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_close_reason_layout, parent, false)
        return CardCloseHolder(CardCloseReasonLayoutBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return reasonsList.size
    }

    override fun onBindViewHolder(holder: CardCloseHolder, position: Int) {
        val data = reasonsList[position]
        holder.binding.apply {
            checkBox.text = data
        }
    }

    fun setReasonsList(list: List<String>) {
        reasonsList = arrayListOf()
        reasonsList.addAll(list)
        notifyDataSetChanged()
    }
}