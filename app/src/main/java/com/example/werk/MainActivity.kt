package com.example.werk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.werk.klassen.Customer
import com.example.werk.klassen.JobPerformance
import com.example.werk.klassen.JobPerformanceListAdapter
import kotlinx.android.synthetic.main.fragment_overview.*
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    var listCustomers = ArrayList<Customer>()
    var listJobPerformances =ArrayList<JobPerformance>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listCustomers.add(
            Customer(
                1,
                "Ceulemans Peter",
                "Aannemer",
                " 0476418746 ",
                "peterceulemans.bvba@skynet.be",
                "Schriekstraat 140 2223 Schriek ",
                "",
                "",
                "BE0860 733 953 "
            )

        )

    }
}

