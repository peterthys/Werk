package com.example.werk.klassen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.werk.R
import kotlinx.android.synthetic.main.ticket_job_performances_overview.view.*

class JobPerformanceListAdapter(private val jobPerformanceList: ArrayList<JobPerformance>) :
    RecyclerView.Adapter<JobPerformanceListAdapter.JobPerformanceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobPerformanceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.ticket_job_performances_overview,
            parent, false
        )
        return JobPerformanceViewHolder(itemView)
    }

    override fun getItemCount(): Int = jobPerformanceList.size

    override fun onBindViewHolder(holder: JobPerformanceViewHolder, position: Int) {
        val currentJP = jobPerformanceList[position]

        holder.textView1.text = currentJP.customer.toString()
        holder.textView2.text = currentJP.beginTime.toString()
        holder.textView3.text = currentJP.endTime.toString()
        holder.textView4.text = currentJP.pause.toString()
    }

    class JobPerformanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.tv_customer
        val textView2: TextView = itemView.tv_startTime
        val textView3: TextView = itemView.tv_endTime
        val textView4: TextView = itemView.tv_pause
    }

}