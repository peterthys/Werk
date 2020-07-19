package com.example.werk.klassen

import androidx.lifecycle.LiveData
import com.example.werk.database.CustomerDao

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class CustomerRepository(
    private val customerDao: CustomerDao
) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allCustomers: LiveData<List<Customer>> = customerDao.getAll()
    val allCustomerNames: LiveData<List<String>> = customerDao.getAllNames()

    suspend fun insertCustomer(customer: Customer) {
        customerDao.insert(customer)
    }

    suspend fun saveCustomer(customer: Customer) {
        customerDao.save(customer)
    }

}