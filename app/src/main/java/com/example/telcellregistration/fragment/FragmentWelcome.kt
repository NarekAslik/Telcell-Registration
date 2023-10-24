package com.example.telcellregistration.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.WelcomeFragmentBinding

class FragmentWelcome : Fragment(R.layout.welcome_fragment) {
    private lateinit var binding: WelcomeFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = WelcomeFragmentBinding.bind(view)
        binding.enterButton.setOnClickListener {
         findNavController().navigate(R.id.fragmentLogIn)
        }
    }

}