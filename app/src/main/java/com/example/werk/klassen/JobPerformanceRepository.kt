package com.example.werk.klassen

import androidx.lifecycle.LiveData
import com.example.werk.database.CustomersDao
import com.example.werk.database.JobPerformanceDao

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class JobPerformanceRepository(
    private val jobPerformanceDao: JobPerformanceDao,
    private val customersDao: CustomersDao
) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allJobPerformances: LiveData<List<JobPerformance>> = jobPerformanceDao.getAll()
    val allCustomers: LiveData<List<Customer>> = customersDao.getAll()

    suspend fun insert(jobPerformance: JobPerformance) {
        jobPerformanceDao.insert(jobPerformance)
    }

    suspend fun insertCustomer(customer: Customer) {
        customersDao.insert(customer)
    }

}