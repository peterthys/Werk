package com.example.werk.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.werk.R
import com.example.werk.database.JobPerformance
import com.example.werk.viewmodels.CustomerViewModel
import com.example.werk.viewmodels.NewJobPerformanceViewModel
import kotlinx.android.synthetic.main.fragment_new_job_performance.*
import java.text.SimpleDateFormat


class NewJobPerformanceFragment : Fragment() {

    private lateinit var newJobPerformanceViewModel: NewJobPerformanceViewModel
    private lateinit var customerViewModel: CustomerViewModel

    var beginTime = 0L
    var endTime = 0L
    var pauseHours = 0
    var pauseMinutes = 0
    var pause : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_job_performance, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_selectEndTime.setVisibility(View.GONE)
        bt_endTime.setVisibility(View.GONE)
        btn_change_customer.setOnClickListener {
            tv_customer_name.text = "...."
            btn_change_customer.setVisibility(View.GONE)
            bt_new_customer.setVisibility(View.VISIBLE)
            btn_other_customer.setVisibility(View.VISIBLE)
        }

        bt_new_customer.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_newJobPerformanceFragment_to_newCustomerFragment)
        }
        btn_other_customer.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_newJobPerformanceFragment_to_customerOverviewFragment)
        }

        bt_overview.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_newJobPerformanceFragment_to_jobPerformanceOverviewFragment)
        }

        bt_beginTime.setOnClickListener {
//            if (tv_customer_name.text=="...."||tv_customer_name.text==null){
//                Toast.makeText(view.getContext(),"First select or create a customer pls !",Toast.LENGTH_LONG).show()
//           }
//
//            else
            if (checkCustomerName()) {

                tv_selectBeginTime.setVisibility(View.GONE)
                tv_selectEndTime.setVisibility(View.VISIBLE)
                bt_endTime.setVisibility(View.VISIBLE)
                bt_beginTime.setEnabled(false)
                showBeginTime()
            }
            bt_endTime.setOnClickListener {
                bt_endTime.setEnabled(false)
                showEndTime()
                calculateResult()
            }

            val pickerHours = np_pause_hours
            val pickerMinutes = np_pause_minutes
            pickerMinutes.minValue = 0
            pickerMinutes.maxValue = 60
            pickerMinutes.value = 30
            pickerHours.minValue = 0
            pickerHours.maxValue = 12
            pickerHours.wrapSelectorWheel = true

            pickerMinutes.wrapSelectorWheel = true



        }

    }
    fun checkCustomerName(): Boolean {
        val name = tv_customer_name.text
        if (tv_customer_name.text=="...."||tv_customer_name==null) {
            bt_beginTime.error = "First select or create a customer pls !"

          Toast.makeText(view?.getContext(),"First select or create a customer pls !",Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newJobPerformanceViewModel = ViewModelProvider(requireActivity()).get(NewJobPerformanceViewModel::class.java)
        newJobPerformanceViewModel.allCustomerNames.observe(viewLifecycleOwner, Observer { customerNames ->
            // Update the cached copy of the words in the adapter.
//            if (customerNames.size > 1) {
//                np_customers.maxValue = customerNames?.size!! - 1
//                np_customers.displayedValues = customerNames.toTypedArray()
//            }
        })
        customerViewModel = ViewModelProvider(requireActivity()).get(CustomerViewModel::class.java)
        tv_customer_name.text = customerViewModel.getChosenCustomer()!!.customerName

        bt_add.setOnClickListener {
            calculateResult()
            bt_beginTime.isEnabled
            bt_endTime.isEnabled

          //  val customerIndex = np_customers.value
            val customerName = tv_customer_name.text.toString()
            val jobPerformance = JobPerformance(
                0,
                customerName,
                beginTime,
                endTime,
                pause)

            newJobPerformanceViewModel.saveJobPerformance(jobPerformance)
            view?.findNavController()?.navigate(R.id.action_newJobPerformanceFragment_to_jobPerformanceOverviewFragment)

        }
    }

    private fun showBeginTime() {
        beginTime = System.currentTimeMillis()
        bt_beginTime.text = SimpleDateFormat(" EE dd-MM-yyyy'" + " \n 'HH:mm")
            .format(beginTime).toString()
    }

    fun showEndTime() {

        endTime = System.currentTimeMillis()
        bt_endTime.text = SimpleDateFormat(" EE dd-MM-yyyy'" + " \n 'HH:mm")
            .format(endTime).toString()

    }

    fun calculateResult(): String {
        pauseHours = np_pause_hours.value
        pauseMinutes = np_pause_minutes.value
        pause = (pauseHours*60 + pauseMinutes)*60000
        val timeWorked = (endTime - beginTime) - pause
        //  ((endTimeInHours * 60) + (endTimeInMinutes)) - ((beginTimeInHours * 60) + (beginTimeInMinutes)) - pauzeTotaal
        val timeWorkedInHours = timeWorked / 3600000
        val timeWorkedInMinutes = timeWorked / 60000
        val result: String =
            timeWorkedInHours.toString() + " u  " + timeWorkedInMinutes.toString() + " min."

        return result

    }

//    companion object {
//        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
//    }
}




