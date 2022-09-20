package com.example.hinge_homework.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.hinge_homework.databinding.ActivityMainBinding
import com.example.hinge_homework.domain.models.User
import com.example.hinge_homework.ui.adapter.OfficePagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { users ->
                binding.apply {
                    val pagerAdapter = OfficePagerAdapter(users)
                    pager.adapter = pagerAdapter
                }
            }
        }

        binding.apply {
            pager.isUserInputEnabled = false
            fab.setOnClickListener { nextProfile() }
        }
    }

    private fun nextProfile() {
        binding.pager.currentItem = binding.pager.currentItem + 1
    }
}