package com.example.flowapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.flowapplication.channel.ChannelFragment
import com.example.flowapplication.flow.FlowFragment
import com.example.flowapplication.liveData.LiveDataFragment
import com.example.flowapplication.sharedFlow.SharedFlowFragment
import com.example.flowapplication.stateFlow.StateFlowFragment

class GeneralFragment : Fragment() {
    lateinit var stateFlowButton: Button
    lateinit var liveDataButton: Button
    lateinit var sharedFlowButton: Button
    lateinit var flowButton: Button
    lateinit var channelButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_general, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stateFlowButton = view.findViewById(R.id.state_flow_button)
        liveDataButton = view.findViewById(R.id.live_data_button)
        sharedFlowButton = view.findViewById(R.id.shared_flow_button)
        flowButton = view.findViewById(R.id.flow_button)
        channelButton = view.findViewById(R.id.channel_button)

        stateFlowButton.setOnClickListener {
            val fragment = StateFlowFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.host_fragment, fragment)?.commit()
        }

        liveDataButton.setOnClickListener {
            val fragment = LiveDataFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.host_fragment, fragment)?.commit()
        }

        sharedFlowButton.setOnClickListener {
            val fragment = SharedFlowFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.host_fragment, fragment)?.commit()
        }

        flowButton.setOnClickListener {
            val fragment = FlowFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.host_fragment, fragment)?.commit()
        }

        channelButton.setOnClickListener {
            val fragment = ChannelFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.host_fragment, fragment)?.commit()
        }
    }
}
