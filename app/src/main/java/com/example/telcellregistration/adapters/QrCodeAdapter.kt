package com.example.telcellregistration.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.lifecycle.Lifecycle
import com.example.telcellregistration.fragment.FragmentMyQrCode
import com.example.telcellregistration.fragment.FragmentScanCode

class QrCodeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) FragmentScanCode()
        else FragmentMyQrCode()
    }
}