package com.example.flowapplication.channel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChannelViewModel: ViewModel() {
    val channel = Channel<Int>()

    init {
        viewModelScope.launch {
            repeat(10) {
                channel.send(it)
                delay(1000)
            }
        }
    }
}