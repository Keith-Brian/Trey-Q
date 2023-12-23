package com.devkaybee.treyq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devkaybee.treyq.ViewModel.MqttViewModel
import com.devkaybee.treyq.databinding.FragmentStatusBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat.CLOCK_24H
import com.google.firebase.database.DatabaseReference

class StatusFragment : Fragment(R.layout.fragment_status) {

    private var hour: String? =null
    private var min: String? =null

    private lateinit var statusScreen: FragmentStatusBinding
    private lateinit var mqttViewModel: MqttViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        statusScreen = FragmentStatusBinding.bind(view)


        mqttViewModel = ViewModelProvider(this).get(MqttViewModel::class.java)
        //connecting to the server option
        mqttViewModel.connect(requireContext())

        // adafruitViewModel.subscribe("temp")

        mqttViewModel.temp().observe(requireActivity(), Observer {
            statusScreen.Temp.text = it
        })

        mqttViewModel.pH().observe(requireActivity(), Observer {
            statusScreen.ph.text = it
        })

        mqttViewModel.turbidity().observe(requireActivity(), Observer {
            statusScreen.turbidity.text = it
        })

        mqttViewModel.status().observe(requireActivity(), Observer {
            statusScreen.status.text = it
        })

        statusScreen.fabSetTime.setOnClickListener {
            openTimePicker()
        }

        statusScreen.normalPH.setOnClickListener {

            mqttViewModel.publish("wapH", "normal",1)

        }

        statusScreen.extremePH.setOnClickListener {

            mqttViewModel.publish("wapH", "extreme",1)

        }


    }

    private fun openTimePicker() {
        val timePicker = MaterialTimePicker.Builder()
            .setTimeFormat(CLOCK_24H)
            .setHour(12)
            .setMinute(40)
            .setTitleText("SCHEDULE MONITORING!")
            .build()
        timePicker.show(childFragmentManager,"TAG")

        timePicker.addOnPositiveButtonClickListener {
            hour = timePicker.hour.toString()
            min = timePicker.minute.toString()

            Toast.makeText(requireContext(), "Monitoring Scheduled at: ${hour.plus(":").plus(min)}", Toast.LENGTH_SHORT).show()

            mqttViewModel.publish("hour", hour!!,1)
            mqttViewModel.publish("min", min!!,1)
        }
    }
    }
