package com.example.flowapplication.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.flowapplication.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val flowButton = view.findViewById<Button>(R.id.flow_button)
        val flowTextView: TextView = view.findViewById(R.id.flowTextView)
        val flowOnClickTextView = view.findViewById<TextView>(R.id.flowTextViewOnButtonClick)
        lifecycleScope.launch {
            triggerFlow().collectLatest {
                flowTextView.text = it
            }
        }

//        flowButton.setOnClickListener {
//            lifecycleScope.launch {
//                triggerFlow().collectLatest {
//                    flowOnClickTextView.text = it
//                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }

    private fun triggerFlow(): kotlinx.coroutines.flow.Flow<String> {
        return  flow {
            repeat(10) {
                emit("Item $it")
                delay(1000)
            }
        }
    }
}