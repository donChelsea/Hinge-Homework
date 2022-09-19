package com.example.hinge_homework.data.dtos

data class UserDto(
    val id: Int,
    val name: String,
    val gender: String,
    val about: String?,
    val photo: String?,
    val school: String?,
    val hobbies: List<String>,
)