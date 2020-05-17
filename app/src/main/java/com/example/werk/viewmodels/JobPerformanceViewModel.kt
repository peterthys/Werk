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


    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allJobPerformances: LiveData<List<JobPerformance>>


    init {
        val jobPerformanceDao = WerkDatabase.getDatabase(application, viewModelScope).jobPerformanceDao()
        val customersDao = WerkDatabase.getDatabase(application, viewModelScope).customersDao()
        repository = JobPerformanceRepository(jobPerformanceDao,customersDao)
        allJobPerformances = repository.allJobPerformances
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(jobPerformance: JobPerformance) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(jobPerformance)
    }
}

