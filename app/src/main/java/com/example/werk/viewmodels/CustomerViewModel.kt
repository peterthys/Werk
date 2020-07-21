package com.example.werk.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.werk.database.WerkDatabase
import com.example.werk.klassen.Customer
import com.example.werk.klassen.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CustomerRepository
    val allCustomers: LiveData<List<Customer>>

    init {
        val customerDao = WerkDatabase.getDatabase(application, viewModelScope).customerDao()
        repository = CustomerRepository(customerDao)
        allCustomers = repository.allCustomers
    }

    fun insertCustomer(customer: Customer) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertCustomer(customer )
    }

}