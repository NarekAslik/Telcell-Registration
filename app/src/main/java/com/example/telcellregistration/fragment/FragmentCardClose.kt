package com.example.telcellregistration.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.telcellregistration.R
import com.example.telcellregistration.adapters.CardCloseAdapter
import com.example.telcellregistration.databinding.CardCloseLayoutFragmentBinding

class FragmentCardClose : Fragment(R.layout.card_close_layout_fragment) {
    private lateinit var binding: CardCloseLayoutFragmentBinding
    private val cardCloseAdapter = CardCloseAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CardCloseLayoutFragmentBinding.bind(view)
        val reasonsList = arrayListOf(
            "Dissatisfied with the conditions of the card",
            "Dissatisfied with the service ",
            "I would like to use a different card",
            "Other"
        )

        binding.cardCloseRcView.apply {
            layoutManager = GridLayoutManager(requireContext(), 1)
            adapter = cardCloseAdapter
        }
        cardCloseAdapter.setReasonsList(reasonsList)
    }
}