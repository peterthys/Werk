package com.example.werk.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.werk.R
import com.example.werk.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*


class MainFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    var beginTimeInHours: Int = 0
    var beginTimeInMinutes: Int = 0
    var endTimeInHours: Int = 0
    var endTimeInMinutes: Int = 0
    var pauseHours = 0
    var pauseMinutes = 0

  //  var customersArray = arrayOf("Customer 1", "Customer 2", "Customer 3", "Customer 4")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       //var customersArray= db.customerDao().getAllNames()

        bt_new_customer.text = "New " +
                "Customer"

//        val arrayAdapter =
//            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, customersArray)

        bt_new_customer.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_newCustomerFragment)
        }

        bt_overview.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_mainFragment_to_jobPerformanceOverviewFragment)
        }

        bt_add.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_overviewFragment)

        }

        bt_beginTime.setOnClickListener {
            showBeginTime()
        }
        bt_endTime.setOnClickListener {
            showEndTime()
        }
//        bt_add.setOnClickListener{
//            calculateResult()
//        }


        val pickerCustomers = np_customers
        if (pickerCustomers != null) {
            pickerCustomers.minValue = 0
            pickerCustomers.wrapSelectorWheel = true
            //pickerCustomers.maxValue = customersArray.size - 1
            //pickerCustomers.displayedValues = customersArray
        }
        val pickerHours = np_pause_hours
        pickerHours.minValue = 0
        pickerHours.maxValue = 12
        pickerHours.wrapSelectorWheel = true

        val pickerMinutes = np_pause_minutes
        pickerMinutes.minValue = 0
        pickerMinutes.maxValue = 60
        pickerMinutes.value = 30
        pickerMinutes.wrapSelectorWheel = true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.allCustomerNames.observe(viewLifecycleOwner, Observer { customerNames ->
            // Update the cached copy of the words in the adapter.
            if (customerNames.size > 1) {
                np_customers.maxValue = customerNames?.size!! - 1
                np_customers.displayedValues = customerNames.toTypedArray()
            }
        })
    }

    private fun showBeginTime() {
        val t3 = Calendar.getInstance()
        beginTimeInHours = t3.get(Calendar.HOUR_OF_DAY)
        beginTimeInMinutes = t3.get(Calendar.MINUTE)
        val result = beginTimeInHours.toString() + ":" + beginTimeInMinutes.toString()
        bt_beginTime.text = result
    }

    fun showEndTime() {

        val t4 = Calendar.getInstance()
        endTimeInHours = t4.get(Calendar.HOUR_OF_DAY)
        endTimeInMinutes = t4.get(Calendar.MINUTE)
        val result = endTimeInHours.toString() + ":" + endTimeInMinutes.toString()
        bt_endTime.text = result

    }
    fun calculateResult() {
        pauseHours = np_pause_hours.value
        pauseMinutes = np_pause_minutes.value
        val pauzeTotaal = pauseHours * 60 + pauseMinutes
        var timeWorked =
            ((endTimeInHours * 60) + (endTimeInMinutes)) - ((beginTimeInHours * 60) + (beginTimeInMinutes)) - pauzeTotaal
        var timeWorkedInHours: Int = timeWorked / 60
        var timeWorkedInMinutes: Int = timeWorked - timeWorkedInHours * 60
        var result: String =
            timeWorkedInHours.toString() + " u  " + timeWorkedInMinutes.toString() + " min."
        bt_add.text = result
    }
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}




