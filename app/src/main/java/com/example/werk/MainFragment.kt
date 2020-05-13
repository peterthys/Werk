package com.example.werk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var customersArray = arrayOf("Customer 1","Customer 2","Customer 3","Customer 4")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, customersArray )

        sp_spinner.adapter = arrayAdapter
        sp_spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //tv_customer.text= customersArray[position]

            }
        }

        bt_customer.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_newCustomerFragment)
        }

        bt_overview.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_overviewFragment)
        }

        bt_add.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_overviewFragment)
        }
    }
}