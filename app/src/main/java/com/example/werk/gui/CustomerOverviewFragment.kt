package com.example.werk.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.werk.R
import com.example.werk.klassen.Customer
import com.example.werk.klassen.JobPerformance
import kotlinx.android.synthetic.main.fragment_customer_overview.*
import java.util.*

class CustomerOverviewFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_overview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var listCustomers = ArrayList<Customer>()
        var listJobPerformances = ArrayList<JobPerformance>()

        listCustomers.add(
            Customer(
                1,
                "Ceulemans Peter",
                "Aannemer  ",
                "0476418746",
                "peterceulemans.bvba@skynet.be ",
                "Schriekstraat 140 2223 Schriek",
                "dfgdfg",

                "BE0860 733 953 ",
                "123123123"
            )

        )

//        var begintijd = Calendar.getInstance().time
//        var eindtijd = Calendar.getInstance().time
//
//        listJobPerformances.add(JobPerformance(0, 0, begintijd, eindtijd, 30))
//        listJobPerformances.add((JobPerformance(1, 1, begintijd, eindtijd, 60)))
        try {
            recycler_view_customer.adapter =
                CustomerListAdapter(
                    listCustomers
                )
            recycler_view_customer.layoutManager = LinearLayoutManager(context)
            recycler_view_customer.setHasFixedSize(true)
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

}
