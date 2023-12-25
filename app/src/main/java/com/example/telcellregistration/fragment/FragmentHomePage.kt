package com.example.telcellregistration.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.telcellregistration.R
import com.example.telcellregistration.adapters.HomePageAdapter
import com.example.telcellregistration.databinding.HomePageFragmentBinding
import com.example.telcellregistration.dataclasses.*
import com.example.telcellregistration.dialog.CONFIRM_RESULT
import com.example.telcellregistration.dialog.KEY_CONFIRM_TEXT
import com.example.telcellregistration.interfaces.HomeItemClickListener
import com.example.telcellregistration.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

class FragmentHomePage : Fragment(R.layout.home_page_fragment), HomeItemClickListener {

    private val homeViewModel: HomeViewModel by viewModels()
    private val homePageAdapter = HomePageAdapter()
    lateinit var binding: HomePageFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("myLog", "in onCreate Method")
        getHomeItemsList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HomePageFragmentBinding.bind(view)
        Log.d("myLog", "in onViewCreated Method")

        homePageAdapter.setHomeItemClickListener(this@FragmentHomePage)

        binding.homeRecyclerView.apply {
            adapter = homePageAdapter
            layoutManager = GridLayoutManager(requireContext(), 1)
        }
        setFragmentResultListener(CONFIRM_RESULT) { _, bundle ->
            val result = bundle.getString(KEY_CONFIRM_TEXT)
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
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
        findNavController().navigate(R.id.fragmentEmpty)
    }

    override fun bnplItemClick(bnplData: BnplData) {
        Toast.makeText(context, "bnpl clicked", Toast.LENGTH_SHORT).show()
    }

    override fun visaCardClick() {
        findNavController().navigate(R.id.discardDialogFragment)
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

    override fun plusIconClickListener(myBalanceData: MyBalanceData) {
        findNavController().navigate(R.id.fragmentSupplement)
    }
}