package com.example.werk.gui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.werk.R
import com.example.werk.klassen.Customer
import kotlinx.android.synthetic.main.ticket_customers_overview.view.*

class CustomerListAdapter internal constructor(context: Context) : RecyclerView.Adapter<CustomerListAdapter.CustomerViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var customers = emptyList<Customer>() // Cached copy of words

    inner class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.tv_customerName
        val textView2: TextView = itemView.tv_email
        val textView3: TextView = itemView.tv_phone
        val textView4: TextView = itemView.tv_adress1
        val textView5: TextView = itemView.tv_adress2
        val textView6: TextView = itemView.tv_description
        val textView7: TextView = itemView.tv_BTWnr
        val textView8: TextView = itemView.tv_info
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val itemView = inflater.inflate(
            R.layout.ticket_customers_overview,
            parent, false
        )
        return CustomerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val currentJP = customers[position]

        holder.textView1.text = currentJP.customerName
        holder.textView2.text = currentJP.customerEmail
        holder.textView3.text = currentJP.customerPhone
        holder.textView4.text = currentJP.customerAdress1
        holder.textView5.text = currentJP.customerAdress2
        holder.textView6.text = currentJP.customerDescription
        holder.textView7.text = currentJP.customerBTWnr
        holder.textView8.text = currentJP.customerInfo
    }


    internal fun setCustomers(customers: List<Customer>) {
        this.customers = customers
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = customers.size

}