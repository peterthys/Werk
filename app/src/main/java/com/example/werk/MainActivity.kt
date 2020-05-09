package com.example.werk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.ticket_overview.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var customersArray = arrayOf("Customer 1","Customer 2","Customer 3","Customer 4")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, customersArray )

        sp_spinner.adapter = arrayAdapter
        sp_spinner.onItemSelectedListener = object :


            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tv_customer.text= customersArray[position]

            }

        }
    }
}

