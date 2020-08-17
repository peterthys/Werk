package com.example.werk.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.werk.R
import com.example.werk.database.Customer
import com.example.werk.viewmodels.CustomerViewModel
import com.example.werk.viewmodels.NewCustomerViewModel
import kotlinx.android.synthetic.main.fragment_new_customer.*


class NewCustomerFragment : Fragment() {
    private lateinit var newCustomerViewModel: NewCustomerViewModel

    val args: NewCustomerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_new_customer, container, false)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // newCustomerViewModel = ViewModelProvider(this).get(NewCustomerViewModel::class.java)
        newCustomerViewModel = ViewModelProvider(requireActivity()).get(NewCustomerViewModel::class.java)

        val id = args.customerId
        if (id > 0){
            val customerToUpdate : Customer = newCustomerViewModel.getCustomerById(id)
            et_name.text =customerToUpdate.customerName.toString()
            et_description.text= customerToUpdate.customerDescription.toString()
        } else
        //      zoek customer by id: viewModel.getCustomerById(id)
        //      als customer gevonden: data invullen in textviews enz
        // else => add customer


        bt_add.setOnClickListener {
            if (checkCustomer()) {
                // 1. Customer maken
                var customer = Customer()
                customer.customerName = et_name.text.toString()
                customer.customerDescription = et_description.text.toString()
                customer.customerEmail = et_email.text.toString()
                customer.customerPhone = et_phone.text.toString()
                customer.customerAdress1 = et_adress1.text.toString()
                customer.customerAdress2 = et_adress2.text.toString()
                customer.customerBTWnr = et_btw.text.toString()
                customer.customerInfo = et_info.text.toString()

                // 2. NewCustomerViewModel.saveCustomer(...)
                newCustomerViewModel.saveCustomer(customer)

                // 3. Terug naar customer overview
                view?.findNavController()
                    ?.navigate(R.id.action_customerFragment_to_customerOverviewFragment)
            }
        }
    }

    private fun checkCustomer(): Boolean {
        val name = et_name.text
        if (name.isEmpty()) {
            et_name.error = "Naam mag niet leeg !"
            return false
        }

        return true
    }
    fun showUpdateCustomer(customer: Customer){

    }


}
