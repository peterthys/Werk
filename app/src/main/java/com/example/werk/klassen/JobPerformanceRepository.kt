package com.example.werk.klassen

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class JobPerformanceRepository(private val jobPerformanceDao:JobPerformanceDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allJobPerformanceDao: LiveData<List<JobPerformance>> = jobPerformanceDao.getAll()

    suspend fun insert(jobPerformance: JobPerformance) {
        jobPerformanceDao.insert(jobPerformance)
    }
}