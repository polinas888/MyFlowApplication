package com.example.flowapplication.liveData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.flowapplication.R

class LiveDataFragment: Fragment() {
    private val liveDataViewModel by viewModels<LiveDataViewModel>()
    lateinit var liveDataTextView: TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_live_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val liveDataButton = view.findViewById<Button>(R.id.live_data_button)
        val liveDataOnClickTextView = view.findViewById<TextView>(R.id.liveDataTextViewOnButtonClick)
        liveDataViewModel.liveData.observe(viewLifecycleOwner) {
            liveDataTextView = view.findViewById(R.id.liveDataTextView)
            liveDataTextView.text = it
        }

        liveDataButton.setOnClickListener {
            liveDataViewModel.liveData.observe(viewLifecycleOwner) {
                liveDataOnClickTextView.text = liveDataViewModel.liveData.value
                Toast.makeText(context, liveDataViewModel.liveData.value, Toast.LENGTH_SHORT).show()
            }
        }
    }
}