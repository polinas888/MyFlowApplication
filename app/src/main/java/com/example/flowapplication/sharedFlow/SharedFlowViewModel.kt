package com.example.flowapplication.sharedFlow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.launch

class SharedFlowViewModel: ViewModel() {
    private var number = 0
    private val _sharedFlow = MutableSharedFlow<String>(replay = 2)
    val sharedFlow: SharedFlow<String> = _sharedFlow

    init {
        viewModelScope.launch {
            while (true) {
               _sharedFlow.emit("number $number")
                number += 1
                delay(1000)
            }
        }
    }
}