package com.example.werk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.werk.viewmodels.JobPerformanceViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var jobPerformanceViewModelViewModel: JobPerformanceViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}