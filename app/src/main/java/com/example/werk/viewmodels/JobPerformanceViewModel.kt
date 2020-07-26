package com.example.werk.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.werk.database.WerkDatabase
import com.example.werk.klassen.JobPerfomanceRepository
import com.example.werk.database.JobPerformance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JobPerformanceViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: JobPerfomanceRepository

    val allJobPerformances: LiveData<List<JobPerformance>>


    init {
        val jobPerformanceDao = WerkDatabase.getDatabase(application, viewModelScope).jobPerformanceDao()
        repository = JobPerfomanceRepository(jobPerformanceDao)
        allJobPerformances = repository.allJobPerformances
    }



}

