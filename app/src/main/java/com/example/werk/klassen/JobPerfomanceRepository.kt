package com.example.werk.klassen

import androidx.lifecycle.LiveData
import com.example.werk.database.JobPerformance
import com.example.werk.database.JobPerformanceDao

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class JobPerfomanceRepository(
    private val jobPerformanceDao: JobPerformanceDao
) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allJobPerformances: LiveData<List<JobPerformance>> = jobPerformanceDao.getAll()


    suspend fun insertJobPerformance(jobPerformance: JobPerformance) {
        jobPerformanceDao.insert(jobPerformance)
    }
    suspend fun deleteJobPerformance(jobPerformance: JobPerformance) {
        jobPerformanceDao.deleteJobPerformance(jobPerformance)
    }


}