package com.example.werk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.werk.viewmodels.JobPerformanceViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var jobPerformanceViewModelViewModel: JobPerformanceViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)


//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_jobPerformance)
//        val adapter = JobPerformanceListAdapter(this)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)


    }


}