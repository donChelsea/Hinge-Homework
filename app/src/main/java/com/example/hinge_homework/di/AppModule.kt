package com.example.hinge_homework.di

import com.example.hinge_homework.data.OfficeApi
import com.example.hinge_homework.data.repository.OfficeRepositoryImpl
import com.example.hinge_homework.domain.repository.OfficeRepository
import com.example.hinge_homework.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object AppModule {

    @Provides
    @Singleton
    fun provideOfficeApi(): OfficeApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OfficeApi::class.java)

    @Provides
    @Singleton
    fun provideOfficeRepository(api: OfficeApi): OfficeRepository = OfficeRepositoryImpl(api)

}