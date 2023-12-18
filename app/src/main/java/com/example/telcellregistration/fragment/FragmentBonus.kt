package com.example.telcellregistration.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.telcellregistration.R
import com.example.telcellregistration.adapters.BonusPageFiltersAdapter
import com.example.telcellregistration.adapters.TopGoodsAdapter
import com.example.telcellregistration.databinding.BonusFragmentBinding
import com.example.telcellregistration.viewmodel.BonusPageViewModel
import kotlinx.coroutines.flow.collectLatest

class FragmentBonus : Fragment(R.layout.bonus_fragment) {
    private lateinit var binding: BonusFragmentBinding
    private val bonusPageFiltersAdapter = BonusPageFiltersAdapter()
    private val topGoodsAdapter = TopGoodsAdapter()
    private val bonusPageViewModel = BonusPageViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBonusFilters()
        getTopGoods()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = BonusFragmentBinding.bind(view)

        binding.apply {
            horizontalRcView.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = bonusPageFiltersAdapter
            }
            verticalRcView.apply {
                layoutManager = GridLayoutManager(requireContext(), 1)
                adapter = topGoodsAdapter
            }
        }
    }

    private fun getBonusFilters() {
        bonusPageViewModel.getBonusItems()
        lifecycleScope.launchWhenStarted {
            bonusPageViewModel.bonusFiltersFlow.collectLatest {
                bonusPageFiltersAdapter.setFiltersList(it)
            }
        }
    }

    private fun getTopGoods() {
        lifecycleScope.launchWhenStarted {
            bonusPageViewModel.topGoodsFlow.collectLatest {
                topGoodsAdapter.setTopGoodsList(it)
            }
        }
    }
}