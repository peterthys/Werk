package com.example.werk.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val recyclerView : RecyclerView = recyclerview_customer
        val adapter = CustomerListAdapter(ArrayList<Customer>())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
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

        try {
            recyclerview_customer.adapter =
                CustomerListAdapter(
                    listCustomers
                )
            recyclerview_customer.layoutManager = LinearLayoutManager(context)
            recyclerview_customer.setHasFixedSize(true)
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

}
