package com.example.werk.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.werk.database.Customer
import com.example.werk.database.WerkDatabase
import com.example.werk.klassen.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerViewModel(application: Application) : AndroidViewModel(application) {

    private val customerRepository: CustomerRepository
    val allCustomers: LiveData<List<Customer>>
    private var chosenCustomer : Customer? = null

    init {
        val customerDao = WerkDatabase.getDatabase(application, viewModelScope).customerDao()
        customerRepository = CustomerRepository(customerDao)
        allCustomers = customerRepository.allCustomers
    }

    fun getChosenCustomer() : Customer? {
        return chosenCustomer
    }

    fun saveCustomer(customer: Customer) = viewModelScope.launch(Dispatchers.IO) {
        customerRepository.insertCustomer(customer)
    }

    fun deleteCustomer(customer: Customer) = viewModelScope.launch(Dispatchers.IO) {
        customerRepository.deleteCustomer(customer)
    }

    fun onSelectedCustomer(customer: Customer) {
        chosenCustomer = customer
    }
    fun updateCustomer(customer: Customer){

    }
}