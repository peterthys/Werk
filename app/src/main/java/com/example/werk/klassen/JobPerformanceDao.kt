package com.example.werk.klassen

import androidx.room.*

@Dao

interface JobPerformanceDao {

    @Query("SELECT * FROM jobPerformance_table")
    fun getAll(): List<JobPerformance>

    @Query("SELECT * FROM jobPerformance_table WHERE tableCustomer LIKE :title")
    fun findByTitle(title: String): JobPerformance

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(jobPerformance: JobPerformance)


    @Delete
    fun delete(jobPerformance: JobPerformance)

    @Update
    suspend fun updateJobPerformance(jobPerformance: JobPerformance)
}
