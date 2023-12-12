package com.example.telcellregistration.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.ServiceItemBinding
import com.example.telcellregistration.dataclasses.ServicesData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class ServicesAdapter : RecyclerView.Adapter<ServicesAdapter.ServicesHolder>() {
    private var homeItemClickListener: HomeItemClickListener? = null
    private var servicesList = ArrayList<ServicesData>()

    class ServicesHolder(val binding: ServiceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_item, parent, false)
        return ServicesHolder(ServiceItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ServicesHolder, position: Int) {
        val data = servicesList[position]
        holder.binding.apply {
            Glide.with(iconImage)
                .load(data.serviceIcon)
                .into(iconImage)
            serviceName.text = data.serviceText
            holder.itemView.setOnClickListener {
                homeItemClickListener?.serviceItemClick(data)
            }
        }
    }

    override fun getItemCount(): Int = servicesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setServicesList(list: List<ServicesData>) {
        servicesList = arrayListOf()
        servicesList.addAll(list)
        notifyDataSetChanged()
    }

    fun setServiceItemClickListener(listener: HomeItemClickListener?) {
        homeItemClickListener = listener
    }
}