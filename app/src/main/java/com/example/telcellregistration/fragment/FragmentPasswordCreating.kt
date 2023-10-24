package com.example.telcellregistration.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.AuthenticationFragmentBinding
import com.example.telcellregistration.databinding.PasswordCreatingLayoutBinding

class FragmentPasswordCreating : Fragment(R.layout.password_creating_layout) {
    private lateinit var binding: PasswordCreatingLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PasswordCreatingLayoutBinding.bind(view)
    }
}