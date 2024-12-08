package com.example.coroutinescopes.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinescopes.model.repository.FetchRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ratna Srivastava on 05-12-2024.
 */
class FetchingDataViewModel @Inject constructor(private val repository: FetchRepository): ViewModel() {
    private val _fetchedData = MutableLiveData<String>()
    val fetchedData: LiveData<String> get() = _fetchedData

    fun fetchData() {
        viewModelScope.launch {val data = repository.getData()
            _fetchedData.value = data
            println("data from vm is $data")
        }
    }
}