package com.example.hinge_homework.domain.models

data class User(
    val id: Int,
    val name: String,
    val gender: String,
    val about: String?,
    val photo: String?,
    val school: String?,
    val hobbies: List<String>,
)
