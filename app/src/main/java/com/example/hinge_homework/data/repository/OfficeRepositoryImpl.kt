package com.example.hinge_homework.data.repository

import com.example.hinge_homework.domain.models.Profile
import com.example.hinge_homework.domain.models.User
import com.example.hinge_homework.domain.repository.OfficeRepository
import com.example.hinge_homework.util.Resource
import kotlinx.coroutines.flow.Flow

class OfficeRepositoryImpl: OfficeRepository {

    override suspend fun getUsers(): Flow<Resource<List<User>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getConfig(): Flow<Resource<Profile>> {
        TODO("Not yet implemented")
    }
}