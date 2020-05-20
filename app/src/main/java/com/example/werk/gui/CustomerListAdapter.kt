package com.example.werk.gui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.werk.R
import com.example.werk.klassen.Customer
import kotlinx.android.synthetic.main.ticket_customers_overview.view.*
import java.text.SimpleDateFormat
import java.util.*

class CustomerListAdapter (private val customersList: ArrayList<Customer>) :
    RecyclerView.Adapter<CustomerListAdapter.CustomersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomersViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.ticket_customers_overview,
            parent, false
        )
        return CustomersViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = customersList.size

    override fun onBindViewHolder(holder: CustomersViewHolder, position: Int) {
        val currentJP = customersList[position]

        val dateFormat = SimpleDateFormat("HH:mm", Locale.FRANCE)

        holder.textView1.text = currentJP.customerName
        holder.textView2.text = currentJP.customerEmail
        holder.textView3.text = currentJP.customerPhone
        holder.textView4.text = currentJP.customerAdress1
        holder.textView5.text = currentJP.customerAdress2
        holder.textView6.text = currentJP.customerDescription
        holder.textView7.text = currentJP.customerBTWnr
        holder.textView8.text = currentJP.customerInfo

//        if (currentJP.beginTime != null) {
//            holder.textView2.text = dateFormat.format(currentJP.beginTime)
//        } else {
//            holder.textView2.text = ""
//        }

//        if (currentJP.endTime != null) {
//            holder.textView3.text = dateFormat.format(currentJP.endTime)
//        } else {
//            holder.textView3.text = ""
//        }
    }

    class CustomersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.tv_customerName
        val textView2: TextView = itemView.tv_email
        val textView3: TextView = itemView.tv_phone
        val textView4: TextView = itemView.tv_adress1
        val textView5: TextView = itemView.tv_adress2
        val textView6: TextView = itemView.tv_description
        val textView7: TextView = itemView.tv_BTWnr
        val textView8: TextView = itemView.tv_info








    }

}