package com.example.werk.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.werk.R
import com.example.werk.klassen.Customer
import com.example.werk.viewmodels.NewCustomerViewModel
import kotlinx.android.synthetic.main.fragment_new_customer.*

/**
 * A simple [Fragment] subclass.
 */
class NewCustomerFragment : Fragment() {

    private lateinit var viewModel: NewCustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_new_customer, container, false)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(NewCustomerViewModel::class.java)

        bt_add.setOnClickListener {
            if (checkCustomer()) {
                // 1. Customer maken
                var customer = Customer()
                customer.customerName = et_name.text.toString()
                customer.customerDescription = et_description.text.toString()
                customer.customerEmail = et_email.text.toString()
                //...

                // 2. NewCustomerViewModel.saveCustomer(...)
                viewModel.saveCustomer(customer)

                // 3. Terug naar customer overview
                view?.findNavController()?.navigate(R.id.action_customerFragment_to_customerOverviewFragment)
            }
        }
    }

    private fun checkCustomer() : Boolean {
        val name = et_name.text
        if (name.isEmpty()) {
            et_name.error = "Naam mag niet leeg zijn onnozelaar!"
            return false
        }

        return true
    }
}
