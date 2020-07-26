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
import com.example.werk.viewmodels.JobPerformanceViewModel
import kotlinx.android.synthetic.main.fragment_job_performance_overview.*

/**
 * A simple [Fragment] subclass.
 */
class JobPerformanceOverviewFragment : Fragment() {

    private lateinit var jobPerformanceViewModel: JobPerformanceViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: JobPerformanceListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job_performance_overview, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = recyclerview_jobPerformance
        adapter = JobPerformanceListAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        fab_return_to_mainfragment.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_jobPerformanceOverviewFragment_to_mainFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        jobPerformanceViewModel = ViewModelProvider(this).get(JobPerformanceViewModel::class.java)
        jobPerformanceViewModel.allJobPerformances.observe(
            viewLifecycleOwner,
            Observer { jobPerformances ->
                jobPerformances?.let { adapter.setJobPerformances(it) }
            })
    }
}
