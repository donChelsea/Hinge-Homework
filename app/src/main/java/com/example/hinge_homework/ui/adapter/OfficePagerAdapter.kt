package com.example.hinge_homework.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hinge_homework.R
import com.example.hinge_homework.databinding.FragmentProfileBinding
import com.example.hinge_homework.domain.models.User
import com.example.hinge_homework.util.UtilFunctions.checkIfNull
import com.example.hinge_homework.util.UtilFunctions.formatGender
import com.squareup.picasso.Picasso

class OfficePagerAdapter(private val users: List<User>) :
    RecyclerView.Adapter<OfficePagerAdapter.OfficePagerViewHolder>() {

    inner class OfficePagerViewHolder(private val binding: FragmentProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.apply {
                textviewName.text = user.name
                textviewGenderValue.text = formatGender(user.gender)
                textviewAboutValue.text = checkIfNull(user.about, textviewAbout, textviewAboutValue)
                textviewSchoolValue.text = checkIfNull(user.school, textviewSchool, textviewSchoolValue)
                textviewHobbiesValue.text = checkIfNull(user.hobbies?.joinToString(), textviewHobbies, textviewHobbiesValue)
                Picasso.get()
                    .load(user.photo)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(imageviewProfile)
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