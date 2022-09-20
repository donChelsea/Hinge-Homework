package com.example.hinge_homework.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hinge_homework.data.repository.OfficeRepositoryImpl
import com.example.hinge_homework.domain.models.User
import com.example.hinge_homework.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: OfficeRepositoryImpl
): ViewModel() {

    private val _uiState: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getUsers().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let {
                            _uiState.value = it
                        }
                    }
                    is Resource.Error -> {
                        Log.d("MainViewModel", result.message.toString())
                    }
                    is Resource.Loading -> println(result.data)
                }
            }
        }
    }
}