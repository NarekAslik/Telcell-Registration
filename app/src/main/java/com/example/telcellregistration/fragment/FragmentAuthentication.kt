package com.example.telcellregistration.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.HIDE_IMPLICIT_ONLY
import androidx.fragment.app.Fragment
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.AuthenticationFragmentBinding


class FragmentAuthentication : Fragment(R.layout.authentication_fragment) {
    private lateinit var binding: AuthenticationFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AuthenticationFragmentBinding.bind(view)
        openKeyBoard()

    }

    private fun openKeyBoard() {
        binding.pinInputView.requestFocus()
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(
            binding.pinInputView,
            HIDE_IMPLICIT_ONLY
        );//InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

}