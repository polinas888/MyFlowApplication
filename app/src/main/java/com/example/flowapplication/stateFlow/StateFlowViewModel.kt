package com.example.flowapplication.stateFlow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class StateFlowViewModel: ViewModel() {
    private var number = 0
    private var _stateFlow = MutableStateFlow(String())
    val stateFlow: StateFlow<String> = _stateFlow

    init {
        viewModelScope.launch {
            while (true) {
                _stateFlow.value = "number $number"
                number += 1
                delay(1000)
            }
        }
    }
}