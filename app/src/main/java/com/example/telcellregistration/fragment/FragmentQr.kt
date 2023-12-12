package com.example.telcellregistration.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.telcellregistration.R
import com.example.telcellregistration.adapters.QrCodeAdapter
import com.example.telcellregistration.databinding.QrFragmentLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class FragmentQr : Fragment(R.layout.qr_fragment_layout) {
    lateinit var binding: QrFragmentLayoutBinding

    private val qrCodeAdapter: QrCodeAdapter by lazy {
        QrCodeAdapter(parentFragmentManager, lifecycle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = QrFragmentLayoutBinding.bind(view)

        binding.apply {
            qrLayoutTabLayout.addTab(qrLayoutTabLayout.newTab().setText("Սկանավորել կոդը"))
            qrLayoutTabLayout.addTab(qrLayoutTabLayout.newTab().setText("Իմ QR կոդը"))

            viewPager.adapter = qrCodeAdapter

            TabLayoutMediator(qrLayoutTabLayout, viewPager) { tab, position ->
                tab.text = when (position) {
                    0 -> "Սկանավորել կոդը"
                    1 -> "Իմ QR կոդը"
                    else -> ""
                }
            }.attach()
        }
    }
}