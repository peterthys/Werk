package com.example.werk.klassen

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao

interface JobPerformanceDao {

    @Query("SELECT * FROM jobPerformance_table")
    fun getAll(): LiveData<List<JobPerformance>>

    @Query("SELECT * FROM jobPerformance_table WHERE tableCustomer LIKE :title")
    fun findByTitle(title: String): JobPerformance

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(jobPerformance: JobPerformance)


    @Delete
    fun deleteJobPerformance(vararg jobPerformance: JobPerformance)

    @Update
     fun updateJobPerformance(vararg jobPerformance: JobPerformance)
}
