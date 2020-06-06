package com.example.werk.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.werk.klassen.Customer

@Dao
interface CustomerDao {

        @Query("SELECT * FROM customer_table")
        fun getAll(): LiveData<List<Customer>>

        @Query("SELECT * FROM customer_table WHERE id = :customerId")
        fun findByCustomerId(customerId: Int): Customer

        @Query("SELECT * FROM customer_table WHERE id = :customerName")
        fun findByCustomerName(customerName: String): Customer

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(customer: Customer)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun save(customer: Customer)

        @Query("DELETE FROM customer_table")
        suspend fun deleteAll()

        @Delete
        fun deleteCustomer(vararg customer: Customer)

        @Update
        fun updateCustomer(vararg customer: Customer)


}