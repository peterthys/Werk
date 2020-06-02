package com.example.werk.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.werk.R
import kotlinx.android.synthetic.main.fragment_main.*



class MainFragment : Fragment() {
    var beginTimeInHours: Int = 0
    var beginTimeInMinutes: Int = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
        bt_beginTime.setOnClickListener()
        return view



    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_new_customer.text = "New " +
                "Customer"


        var customersArray = arrayOf("Customer 1", "Customer 2", "Customer 3", "Customer 4")
        val arrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, customersArray)

        bt_new_customer.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_newCustomerFragment)
        }

        bt_overview.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_mainFragment_to_customerOverviewFragment)
        }

        bt_add.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_overviewFragment)
        }

        val pickerCustomers = numberPickerCustomers
        if (pickerCustomers != null) {
            pickerCustomers.minValue = 0
            pickerCustomers.wrapSelectorWheel = true
            pickerCustomers.maxValue = customersArray.size - 1
            pickerCustomers.displayedValues = customersArray
        }
        val pickerHours = numerberPickerHours
        pickerHours.minValue = 0
        pickerHours.maxValue = 12
        pickerHours.wrapSelectorWheel = true

        val pickerMinutes = numberPickerMinutes
        pickerMinutes.minValue = 0
        pickerMinutes.maxValue = 60
        pickerMinutes.value = 30
        pickerMinutes.wrapSelectorWheel = true

        fun showBeginTime(view: View) {

            val buSelected = view as Button
            when (buSelected.id) {
                bt_beginTime.id -> {
                    bt_beginTime.text = "hoera"
//                    val t3 = Calendar.getInstance()
//                    beginTimeInHours = t3.get(Calendar.HOUR_OF_DAY)
//                    beginTimeInMinutes = t3.get(Calendar.MINUTE)
//                    val result = beginTimeInHours.toString() + ":" + beginTimeInMinutes.toString()
//
//                    bt_beginTime.text = result

                }
            }

        }


    }

}

private fun Button.setOnClickListener() {
    TODO("Not yet implemented")
}
