package com.example.werk.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.werk.database.WerkDatabase
import com.example.werk.klassen.JobPerformance
import com.example.werk.klassen.JobPerformanceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JobPerformanceViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: JobPerformanceRepository

    val allJobPerformances: LiveData<List<JobPerformance>>


    init {
        val jobPerformanceDao = WerkDatabase.getDatabase(application, viewModelScope).jobPerformanceDao()
        val customersDao = WerkDatabase.getDatabase(application, viewModelScope).customersDao()
        repository = JobPerformanceRepository(jobPerformanceDao,customersDao)
        allJobPerformances = repository.allJobPerformances
    }

    fun insert(jobPerformance: JobPerformance) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(jobPerformance)
    }
}

