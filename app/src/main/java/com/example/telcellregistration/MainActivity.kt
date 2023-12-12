package com.example.telcellregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.Navigation.findNavController
import com.example.telcellregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeBotNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> loadFragment(R.id.fragmentHomePage)
                R.id.bonus -> loadFragment(R.id.fragmentBonus)
                R.id.qrCode -> loadFragment(R.id.fragmentQr)
                R.id.banking -> loadFragment(R.id.fragmentBanking)
            }
            true
        }
    }

    private fun loadFragment(fragmentId: Int) {
        val navController = findNavController(this, R.id.fragment_container)
        val options = NavOptions.Builder().setPopUpTo(fragmentId, true).build()
        navController.navigate(fragmentId, bundleOf(), options)
    }
}