package com.example.werk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.werk.klassen.Customer
import com.example.werk.klassen.JobPerformance
import com.example.werk.klassen.JobPerformanceListAdapter
import kotlinx.android.synthetic.main.fragment_overview.*
import java.time.LocalDateTime
import java.sql.*
import java.sql.Date
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}

