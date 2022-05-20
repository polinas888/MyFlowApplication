package com.example.flowapplication.liveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LiveDataViewModel: ViewModel() {
    private var number = 0
    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    init {
        viewModelScope.launch {
            while (true) {
                _liveData.value = "number $number"
                number += 1
                delay(2000)
            }
        }
    }
}