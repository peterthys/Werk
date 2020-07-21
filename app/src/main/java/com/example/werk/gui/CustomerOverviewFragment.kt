package com.example.werk.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.werk.R
import com.example.werk.viewmodels.CustomerViewModel
import kotlinx.android.synthetic.main.fragment_customer_overview.*


class CustomerOverviewFragment : Fragment() {

    private lateinit var customerViewModel: CustomerViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomerListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = recyclerview_customer
        adapter = context.let { CustomerListAdapter(it!!) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        fab.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_customerOverviewFragment_to_mainFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        customerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)
        customerViewModel.allCustomers.observe(viewLifecycleOwner, Observer { customers ->
            // Update the cached copy of the words in the adapter.
            customers?.let { adapter.setCustomers(it) }
        })

    }

}
