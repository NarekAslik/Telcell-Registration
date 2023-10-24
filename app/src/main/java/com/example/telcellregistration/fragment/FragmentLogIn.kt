package com.example.telcellregistration.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.LoginFragmentBinding

class FragmentLogIn : Fragment(R.layout.login_fragment) {
    private lateinit var binding: LoginFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginFragmentBinding.bind(view)
        binding.confirmButton.setOnClickListener {
            if (binding.phoneNumberEdText.text.isNullOrEmpty())
                Toast.makeText(context, "Put phone number", Toast.LENGTH_SHORT).show()
            else findNavController().navigate(R.id.fragmentAuthentication)
        }
    }

}
