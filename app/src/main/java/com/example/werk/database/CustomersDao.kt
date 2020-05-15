package com.example.werk.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.werk.klassen.Customer

@Dao
interface CustomersDao {



        @Query("SELECT * FROM customer_table")
        fun getAll(): LiveData<List<Customer>>

        @Query("SELECT * FROM customer_table WHERE customerId = :customerId")
        fun findByCustomerId(customerId: Int): Customer

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(customer: Customer)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun save(customer: Customer)


        @Delete
        fun deleteJobPerformance(vararg customer: Customer)

        @Update
        fun updateJobPerformance(vararg customer: Customer)


}