package com.example.hinge_homework.data.dtos

import com.example.hinge_homework.domain.models.User

data class UserDto(
    val id: Int?,
    val name: String?,
    val gender: String?,
    val about: String?,
    val photo: String?,
    val school: String?,
    val hobbies: List<String>?,
) {
    fun toDomain() = User(
        id, name, gender, about, photo, school, hobbies
    )
}