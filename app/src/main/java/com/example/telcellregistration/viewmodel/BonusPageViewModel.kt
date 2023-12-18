package com.example.telcellregistration.viewmodel

import androidx.lifecycle.ViewModel
import com.example.telcellregistration.dataclasses.BonusFiltersData
import com.example.telcellregistration.dataclasses.BonusTopGoodsData
import com.example.telcellregistration.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BonusPageViewModel : ViewModel() {
    private val repository = Repository()
    var bonusFiltersFlow = MutableStateFlow<List<BonusFiltersData>>(arrayListOf())
    var topGoodsFlow = MutableStateFlow<List<BonusTopGoodsData>>(arrayListOf())

    fun getBonusItems() {
        CoroutineScope(IO).launch {
            val data = repository.getItemsForBonus().body()
            if (data != null) {
                bonusFiltersFlow.value = data.bonusFilters
                topGoodsFlow.value = data.bonusTopGoods
            }
        }
    }
}