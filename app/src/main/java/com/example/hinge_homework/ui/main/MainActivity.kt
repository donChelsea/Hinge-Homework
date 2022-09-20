package com.example.hinge_homework.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hinge_homework.databinding.ActivityMainBinding
import com.example.hinge_homework.domain.models.User
import com.example.hinge_homework.ui.adapter.OfficePagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = listOf(
            User(name = "Jim", id = 1, gender = "m", about = null, photo = null, hobbies = null, school = null),
            User(name = "Pam", id = 2, gender = "m", about = null, photo = null, hobbies = null, school = null)
        )

        val pagerAdapter = OfficePagerAdapter(users)
        binding.apply {
            pager.adapter = pagerAdapter
            pager.isUserInputEnabled = false
            fab.setOnClickListener { nextProfile() }
        }

    }

    private fun nextProfile() {
        binding.pager.currentItem = binding.pager.currentItem + 1
    }
}