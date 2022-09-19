package com.example.hinge_homework.data.repository

import com.example.hinge_homework.data.OfficeApi
import com.example.hinge_homework.domain.models.Profile
import com.example.hinge_homework.domain.models.User
import com.example.hinge_homework.domain.repository.OfficeRepository
import com.example.hinge_homework.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfficeRepositoryImpl @Inject constructor(
    private val api: OfficeApi
) : OfficeRepository {

    override suspend fun getUsers(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading(isLoading = true))

        val result = api.getUsers()
        with(result) {
            emit(Resource.Success(data = users.map { it.toDomain() }))
        }
    }.catch { e ->
        emit(Resource.Error(message = e.message.toString()))
    }.flowOn(Dispatchers.IO)

    override suspend fun getConfig(): Flow<Resource<Profile>> = flow {
        emit(Resource.Loading(isLoading = true))

        val result = api.getConfig()
        emit(Resource.Success(data = result.toDomain()))
    }.catch { e ->
        emit(Resource.Error(message = e.message.toString()))
    }.flowOn(Dispatchers.IO)
}