package com.example.flowapplication.channel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.flowapplication.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ChannelFragment: Fragment() {
    private val channelViewModel by viewModels<ChannelViewModel>()
    lateinit var channelTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_channel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        channelTextView = view.findViewById(R.id.channelTextView)
       lifecycleScope.launch {
           channelViewModel.channel.receiveAsFlow().collect {
               channelTextView.text = it.toString()
           }
       }
    }
}