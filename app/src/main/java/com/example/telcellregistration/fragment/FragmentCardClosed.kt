package com.example.telcellregistration.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.CardClosedLayoutFragmentBinding

class FragmentCardClosed : Fragment(R.layout.card_closed_layout_fragment) {
    private lateinit var binding: CardClosedLayoutFragmentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CardClosedLayoutFragmentBinding.bind(view)
    }
}