package com.example.werk.klassen

import androidx.lifecycle.LiveData
import androidx.room.*
import java.time.LocalDateTime

@Dao

interface JobPerformanceDao {

    @Query("SELECT * FROM jobPerformance_table")
    fun getAll(): LiveData<List<JobPerformance>>

    @Query("SELECT * FROM jobPerformance_table WHERE customerId = :customerId")
    fun findByCustomerId(customerId: Int): JobPerformance

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(jobPerformance: JobPerformance)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(jobPerformance: JobPerformance)


    @Delete
    fun deleteJobPerformance(vararg jobPerformance: JobPerformance)

    @Update
     fun updateJobPerformance(vararg jobPerformance: JobPerformance)
}
