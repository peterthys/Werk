package com.example.werk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.werk.klassen.Customer
import com.example.werk.klassen.JobPerformance
import com.example.werk.klassen.JobPerformanceListAdapter
import kotlinx.android.synthetic.main.fragment_overview.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class OverviewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var listCustomers = ArrayList<Customer>()
        var listJobPerformances = ArrayList<JobPerformance>()

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
        //var begintijd = LocalDateTime.now()
        //var eindtijd = begintijd
        var begintijd = Calendar.getInstance().time.time
        var eindtijd = Calendar.getInstance().time.time

        listJobPerformances.add(JobPerformance(0, 0, begintijd, eindtijd, 30))
        listJobPerformances.add((JobPerformance(1, 1, begintijd, eindtijd, 60)))
        try {
            recycler_view.adapter = JobPerformanceListAdapter(listJobPerformances)
            recycler_view.layoutManager = LinearLayoutManager(context)
            recycler_view.setHasFixedSize(true)
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

}
