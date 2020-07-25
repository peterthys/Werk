package com.example.werk.klassen

import com.example.werk.database.Customer

data class TicketJPOverview (val customer: Customer, val beginTime : String, val endTime : String,val pause : Int,val result : String)