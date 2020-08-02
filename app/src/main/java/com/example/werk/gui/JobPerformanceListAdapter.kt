package com.example.werk.gui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.werk.R
import com.example.werk.database.JobPerformance
import kotlinx.android.synthetic.main.ticket_job_performances_overview.view.*
import java.text.SimpleDateFormat

class JobPerformanceListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<JobPerformanceListAdapter.JobPerformanceViewHolder>() {

    public interface JobPerformanceListener {
        fun onDeleteJobPerformance(jobPerformance : JobPerformance)
        fun onUpdateJobPerformance(jobPerformance: JobPerformance)
        fun onSelected(jobPerformance: JobPerformance)
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var jobPerformances = emptyList<JobPerformance>()
    private var jobPeformanceListener : JobPerformanceListener? = null

    fun setJobPerformanceListener(jobPerformanceListener: JobPerformanceListener) {
        this.jobPeformanceListener = jobPerformanceListener
    }

    inner class JobPerformanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.tv_customer
        val textView2: TextView = itemView.tv_startTime
        val textView3: TextView = itemView.tv_endTime
        val textView4: TextView = itemView.tv_pause
        val textView5: TextView = itemView.tv_result
        val buttonDelete: Button = itemView.btn_delete
        val buttonUpdate: Button = itemView.btn_update
        val holderView: CardView = itemView as CardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobPerformanceViewHolder {
        val itemView = inflater.inflate(
            R.layout.ticket_job_performances_overview,
            parent, false
        )

        return JobPerformanceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JobPerformanceViewHolder, position: Int) {
        val dateFormat = SimpleDateFormat(" EE dd-MM-yyyy'" + " \n 'HH:mm")

        val currentJP = jobPerformances[position]

        val pauseToHours = currentJP.pause / 3600000
        val pauseToMinutes = currentJP.pause/60000 - pauseToHours*60
        val pauseToString = "$pauseToHours hour $pauseToMinutes min."


        holder.textView1.text = currentJP.customerName
        holder.textView2.text = dateFormat.format(currentJP.beginTime)
        holder.textView3.text = dateFormat.format(currentJP.endTime)
        holder.textView4.text = pauseToString
        holder.textView5.text = currentJP.calculateResult()

        holder.buttonDelete.setOnClickListener {
            val jp : JobPerformance = jobPerformances.get(position)
            jobPeformanceListener?.onDeleteJobPerformance(jp)
        }
        holder.buttonUpdate.setOnClickListener {
            val jp : JobPerformance = jobPerformances.get(position)
            jobPeformanceListener?.onUpdateJobPerformance(jp)
        }

        holder.holderView.setOnClickListener {
            //holder.holderView.setBackgroundColor(Color.GRAY)
            val jp : JobPerformance = jobPerformances.get(position)
            jobPeformanceListener?.onSelected(jp)
        }
    }

    internal fun setJobPerformances(jobPerformances: List<JobPerformance>) {
        this.jobPerformances = jobPerformances
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = jobPerformances.size
}




