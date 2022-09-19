package com.example.hinge_homework.data.dtos

import com.example.hinge_homework.domain.models.Profile

data class ProfileDto(
    val profile: List<String>
) {
    fun toDomain() = Profile(profile)
}