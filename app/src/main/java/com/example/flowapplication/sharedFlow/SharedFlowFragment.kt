package com.example.flowapplication.sharedFlow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.flowapplication.R
import kotlinx.coroutines.flow.collectLatest

class SharedFlowFragment: Fragment() {
    private val sharedFlowViewModel by viewModels<SharedFlowViewModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shared_flow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedFlowText = view.findViewById<TextView>(R.id.sharedFlowTextView)
        val sharedFlowTextOnClick = view.findViewById<TextView>(R.id.sharedFlowTextViewOnButtonClick)
        val sharedFlowButton = view.findViewById<Button>(R.id.shared_flow_button)
        lifecycleScope.launchWhenStarted {
            sharedFlowViewModel.sharedFlow.collectLatest {
                sharedFlowText.text = it
            }
        }

        sharedFlowButton.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                sharedFlowViewModel.sharedFlow.collectLatest {
                    sharedFlowTextOnClick.text = it
                    Toast.makeText(context, it, LENGTH_SHORT).show()
                }
            }
            Log.i("replyLog", sharedFlowViewModel.sharedFlow.replayCache.toString())
        }
    }
}
