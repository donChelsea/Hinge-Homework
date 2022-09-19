package com.example.hinge_homework.data

import com.example.hinge_homework.data.dtos.ListResponseDto
import com.example.hinge_homework.data.dtos.ProfileDto
import com.example.hinge_homework.data.dtos.UserDto
import retrofit2.http.GET

interface OfficeApi {

    @GET("users")
    suspend fun getUsers(): ListResponseDto<UserDto>

    @GET("config")
    suspend fun getConfig(): ProfileDto
}