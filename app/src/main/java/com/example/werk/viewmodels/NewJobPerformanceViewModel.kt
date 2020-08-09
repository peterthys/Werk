package com.example.werk.viewmodels

import android.app.Application
import androidx.arch.core.util.Function
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.werk.database.Customer
import com.example.werk.database.JobPerformance
import com.example.werk.database.WerkDatabase
import com.example.werk.klassen.CustomerRepository
import com.example.werk.klassen.JobPerfomanceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class NewJobPerformanceViewModel (application: Application) : AndroidViewModel(application) {

    private val customerRepository: CustomerRepository
    private val jobPerformanceRepository: JobPerfomanceRepository

    val allCustomerNames: LiveData<List<String>>

    init {
        val customerDao = WerkDatabase.getDatabase(application, viewModelScope).customerDao()
        val jobPerformanceDao = WerkDatabase.getDatabase(application, viewModelScope).jobPerformanceDao()
        customerRepository = CustomerRepository(customerDao)
        jobPerformanceRepository = JobPerfomanceRepository(jobPerformanceDao)
        allCustomerNames = Transformations.map(customerRepository.allCustomers, Function { input ->
            val result: ArrayList<String> = ArrayList<String>()

            for (customer: Customer in input) {
                result.add(customer.customerName)
            }

            return@Function result
        })
    }

    fun saveJobPerformance(jobPerformance: JobPerformance) = viewModelScope.launch(Dispatchers.IO) {
        jobPerformanceRepository.insertJobPerformance(jobPerformance)
    }
    fun deleteJobPerformance(jobPerformance: JobPerformance) = viewModelScope.launch(Dispatchers.IO) {
        jobPerformanceRepository.deleteJobPerformance(jobPerformance)
    }

//    fun insertCustomer(customer: Customer) = viewModelScope.launch(Dispatchers.IO) {
//        repository.insertCustomer(customer )
//    }
}