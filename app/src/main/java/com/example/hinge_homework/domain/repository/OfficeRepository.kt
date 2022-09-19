package com.example.hinge_homework.domain.repository

import com.example.hinge_homework.domain.models.Profile
import com.example.hinge_homework.domain.models.User
import com.example.hinge_homework.util.Resource
import kotlinx.coroutines.flow.Flow

interface OfficeRepository {

    suspend fun getUsers(): Flow<Resource<List<User>>>

    suspend fun getConfig(): Flow<Resource<Profile>>
}