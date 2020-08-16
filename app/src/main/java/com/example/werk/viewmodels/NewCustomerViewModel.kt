package com.example.werk.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.werk.database.Customer
import com.example.werk.database.WerkDatabase
import com.example.werk.klassen.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewCustomerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CustomerRepository
    val customerDao = WerkDatabase.getDatabase(application, viewModelScope).customerDao()

    init {
        val customerDao = WerkDatabase.getDatabase(application, viewModelScope).customerDao()
        repository = CustomerRepository(customerDao)
    }

    fun saveCustomer(customer: Customer) = viewModelScope.launch(Dispatchers.IO) {
        customerDao.save(customer)
    }

    fun showCustomer(customer: Customer): Customer {
        val updateCustomer = customer

        return updateCustomer
    }

}