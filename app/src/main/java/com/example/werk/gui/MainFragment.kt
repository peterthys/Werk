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
import java.text.SimpleDateFormat


class MainFragment : Fragment() {

    var beginTime = 0L
    var endTime = 0L
    var pauseHours = 0
    var pauseMinutes = 0




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       //var customersArray= db.customerDao().getAllNames()


//        val arrayAdapter =
//            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, customersArray)

        bt_new_customer.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_newCustomerFragment)
        }

        bt_overview.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_mainFragment_to_jobPerformanceOverviewFragment)
        }

        bt_beginTime.setOnClickListener {
            bt_beginTime.setEnabled(false)
            showBeginTime()
        }
        bt_endTime.setOnClickListener {
            bt_endTime.setEnabled(false)
            showEndTime()
            calculateResult()
        }
//        bt_add.setOnClickListener{
//            calculateResult()
//        }


        val pickerCustomers = np_customers
        if (pickerCustomers != null) {
            pickerCustomers.minValue = 0
            pickerCustomers.wrapSelectorWheel = true
//            pickerCustomers.maxValue = customersArray.size - 1
//            pickerCustomers.displayedValues = customersArray
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

      val  mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.allCustomerNames.observe(viewLifecycleOwner, Observer { customerNames ->
            // Update the cached copy of the words in the adapter.
            if (customerNames.size > 1) {
                np_customers.maxValue = customerNames?.size!! - 1
                np_customers.displayedValues = customerNames.toTypedArray()
            }
        })
        bt_add.setOnClickListener {
            bt_beginTime.isEnabled
            bt_endTime.isEnabled
//            var jobPerformance = JobPerformance()
//            jobPerformance.customerName=np_customers.toString()
//            jobPerformance.pause=np_pause_minutes
//            jobPerformance.beginTime=bt_beginTime[bt_beginTime?.get]
//            jobPerformance.endTime=0






            view?.findNavController()?.navigate(R.id.action_mainFragment_to_overviewFragment)

        }
    }

    private fun showBeginTime() {
        beginTime = System.currentTimeMillis()
        bt_beginTime.text = SimpleDateFormat(" EE dd-MM-yyyy'"+" \n 'HH:mm")
            .format(beginTime).toString()
    }

    fun showEndTime() {

        endTime = System.currentTimeMillis()
        bt_endTime.text = SimpleDateFormat(" EE dd-MM-yyyy'"+" \n 'HH:mm")
            .format(endTime).toString()

    }
    fun calculateResult():String {
        pauseHours = np_pause_hours.value
        pauseMinutes = np_pause_minutes.value
      val pauzeTotaal = (pauseHours * 60 + pauseMinutes)*60000
       var timeWorked =(endTime-beginTime)
          //  ((endTimeInHours * 60) + (endTimeInMinutes)) - ((beginTimeInHours * 60) + (beginTimeInMinutes)) - pauzeTotaal
        var timeWorkedInHours  = timeWorked / 3600000
        var timeWorkedInMinutes = timeWorked/ 60000
       var result: String =
            timeWorkedInHours.toString() + " u  " + timeWorkedInMinutes.toString() + " min."
 //       bt_add.text = result
        return result

    }
//    companion object {
//        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
//    }
}




