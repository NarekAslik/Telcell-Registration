package com.example.telcellregistration.viewmodel


import androidx.lifecycle.ViewModel
import com.example.telcellregistration.Repository
import com.example.telcellregistration.interfaces.HomeItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {
    private val repository = Repository()
    val homeItemsListFlow = MutableStateFlow<List<HomeItems>>(arrayListOf())

    fun getHomeItems() {
        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getItems().body()
            if (data != null){
                homeItemsListFlow.value= arrayListOf(
                    data.bnplData,
                    data.balanceData,
                    data.bannersData,
                    data.servicesData,
                    data.chosenPaymentData,
                    data.historiesData,
                    data.specialOffersData

                )
            }
        }
    }
}