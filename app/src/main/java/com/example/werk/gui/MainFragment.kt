package com.example.werk.gui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.NumberPicker
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.werk.R
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*


class MainFragment : Fragment() {
    private lateinit var editWordView1: NumberPicker
    private lateinit var editWordView2: Button
    private lateinit var editWordView3: Button
    private lateinit var editWordView4: NumberPicker
    private lateinit var editWordView5: NumberPicker



    var beginTimeInHours: Int = 0
    var beginTimeInMinutes: Int = 0
    var endTimeInHours: Int = 0
    var endTimeInMinutes: Int = 0
    var pauseHours = 0
    var pauseMinutes = 0

    var customersArray = arrayOf("Customer 1", "Customer 2", "Customer 3", "Customer 4")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_main, container, false)

        editWordView1 = np_customers
        editWordView2 = bt_beginTime
        editWordView3 = bt_endTime
        editWordView4 = np_pause_hours
        editWordView5 = np_pause_minutes

        val button = bt_add
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView1.toString())) {
                getActivity()?.setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val customer = editWordView1.toString()
                replyIntent.putExtra(NewCustomerFragment.EXTRA_REPLY, customer)
                getActivity()?.setResult(Activity.RESULT_OK, replyIntent)
            }
            getActivity()?.finish()
        }

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_new_customer.text = "New " +
                "Customer"

        val arrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, customersArray)

        bt_new_customer.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_newCustomerFragment)
        }

        bt_overview.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_mainFragment_to_customerOverviewFragment)
        }

//        bt_add.setOnClickListener {
//            view.findNavController().navigate(R.id.action_mainFragment_to_overviewFragment)
//        }

        bt_beginTime.setOnClickListener {
            showBeginTime()
        }
        bt_endTime.setOnClickListener {
            showEndTime()
        }
        bt_add.setOnClickListener{
            calculateResult()
        }


        val pickerCustomers = np_customers
        if (pickerCustomers != null) {
            pickerCustomers.minValue = 0
            pickerCustomers.wrapSelectorWheel = true
            pickerCustomers.maxValue = customersArray.size - 1
            pickerCustomers.displayedValues = customersArray
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




