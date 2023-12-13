package com.example.telcellregistration.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.telcellregistration.R
import com.example.telcellregistration.adapters.HomePageAdapter
import com.example.telcellregistration.databinding.HomePageFragmentBinding
import com.example.telcellregistration.dataclasses.*
import com.example.telcellregistration.interfaces.HomeItemClickListener
import com.example.telcellregistration.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

class FragmentHomePage : Fragment(R.layout.home_page_fragment), HomeItemClickListener {
    private val homeViewModel = HomeViewModel()
    private val homePageAdapter = HomePageAdapter()
    lateinit var binding: HomePageFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getHomeItemsList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HomePageFragmentBinding.bind(view)
        binding.homeRecyclerView.apply {
            adapter = homePageAdapter
            layoutManager = GridLayoutManager(requireContext(), 1)
        }


    }

    private fun getHomeItemsList() {
        homeViewModel.getHomeItems()
        lifecycleScope.launchWhenStarted {
            homeViewModel.homeItemsListFlow.collectLatest {
                homePageAdapter.setHomeItemsList(it)
            }
        }
    }

    override fun bannerItemClick(bannerData: BannerData) {
        Toast.makeText(context, "Lottery", Toast.LENGTH_SHORT).show()
    }

    override fun bnplItemClick(bnplData: BnplData) {
        Toast.makeText(context, "Lottery", Toast.LENGTH_SHORT).show()
    }

    override fun eyeIconClick(balanceData: MyBalanceData) {
        Toast.makeText(context, "Lottery", Toast.LENGTH_SHORT).show()
    }

    override fun serviceItemClick(serviceData: ServiceData) {
        Toast.makeText(context, "Lottery", Toast.LENGTH_SHORT).show()
    }

    override fun historyItemClick(historyData: HistoryData) {
        Toast.makeText(context, "Lottery", Toast.LENGTH_SHORT).show()
    }

    override fun specialOfferItemClick(specialOfferData: SpecialOfferData) {
        Toast.makeText(context, "Lottery", Toast.LENGTH_SHORT).show()
    }

    init {
        homePageAdapter.setBannerItemClickListener(this)
        homePageAdapter.setBnplItemClickListener(this)
        homePageAdapter.setEyeIconClickListener(this)
        homePageAdapter.setServiceItemClickListener(this)
        homePageAdapter.setHistoryItemClickListener(this)
        homePageAdapter.setSpecialOfferItemClickListener(this)
    }
}