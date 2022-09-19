package com.example.hinge_homework.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hinge_homework.databinding.FragmentProfileBinding
import com.example.hinge_homework.domain.models.User

class OfficePagerAdapter(private val users: List<User>) :
    RecyclerView.Adapter<OfficePagerAdapter.OfficePagerViewHolder>() {

    inner class OfficePagerViewHolder(val binding: FragmentProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.apply {
                textviewName.text = user.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficePagerViewHolder {
        return OfficePagerViewHolder(
            FragmentProfileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OfficePagerViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size
}