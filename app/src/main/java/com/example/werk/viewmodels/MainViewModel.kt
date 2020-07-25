package com.example.werk.viewmodels

import android.app.Application
import androidx.arch.core.util.Function
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.werk.database.WerkDatabase
import com.example.werk.database.Customer
import com.example.werk.klassen.CustomerRepository
import java.util.*

class MainViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: CustomerRepository

    val allCustomerNames: LiveData<List<String>>

    init {
        val customerDao = WerkDatabase.getDatabase(application, viewModelScope).customerDao()
        repository = CustomerRepository(customerDao)

        allCustomerNames = Transformations.map(repository.allCustomers, Function { input ->
            val result: ArrayList<String> = ArrayList<String>()

            for (customer: Customer in input) {
                result.add(customer.customerName)
            }

            return@Function result
        })
    }

//    fun insertCustomer(customer: Customer) = viewModelScope.launch(Dispatchers.IO) {
//        repository.insertCustomer(customer )
//    }
}