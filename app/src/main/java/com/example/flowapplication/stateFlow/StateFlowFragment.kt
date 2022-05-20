package com.example.flowapplication.stateFlow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.flowapplication.R
import kotlinx.coroutines.flow.collectLatest

class StateFlowFragment: Fragment() {
    private val stateFlowViewModel by viewModels<StateFlowViewModel>()
    lateinit var stateFlowButton: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_state_flow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stateFlowText = view.findViewById<TextView>(R.id.stateFlowTextView)
        stateFlowButton = view.findViewById(R.id.state_flow_button)
        val stateFlowOnClickTextView = view.findViewById<TextView>(R.id.stateFlowTextViewOnButtonClick)
        lifecycleScope.launchWhenStarted {
            stateFlowViewModel.stateFlow.collectLatest {
                stateFlowText.text = it
            }
        }

        stateFlowButton.setOnClickListener {
            stateFlowOnClickTextView.text = stateFlowViewModel.stateFlow.value
            Toast.makeText(context, stateFlowViewModel.stateFlow.value, Toast.LENGTH_SHORT).show()
        }
    }
}