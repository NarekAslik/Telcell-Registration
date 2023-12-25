package com.example.telcellregistration.holders

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.BalanceViewBinding
import com.example.telcellregistration.dataclasses.MyBalanceData
import com.example.telcellregistration.interfaces.HomeItemClickListener

class MyBalanceHolder(private val binding: BalanceViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var homeItemClickListener: HomeItemClickListener? = null
    fun bind(myBalanceData: MyBalanceData) {
        binding.apply {
            balance.setText(myBalanceData.balance)
            eyeIcon.setImageResource(R.drawable.ic_eye)
            eyeIcon.setOnClickListener {
                myBalanceData.isVisible = !myBalanceData.isVisible
                if (myBalanceData.isVisible) {
                    eyeIcon.setImageResource(R.drawable.ic_eye)
                    dramIcon.visibility = View.VISIBLE
                    balance.transformationMethod = HideReturnsTransformationMethod.getInstance()
                } else {
                    balance.transformationMethod = PasswordTransformationMethod.getInstance()
                    dramIcon.visibility = View.INVISIBLE
                    eyeIcon.setImageResource(R.drawable.close_eye)
                }
            }
            plusIcon.setOnClickListener {
                homeItemClickListener?.plusIconClickListener(myBalanceData)
            }
        }
    }
    fun setPlusIconClickListener(listener: HomeItemClickListener?) {
        homeItemClickListener = listener
    }
}