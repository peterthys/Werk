package com.example.werk.klassen

import com.example.werk.database.Customer
import java.util.*

data class TicketJPOverview (val customer: Customer, val beginTime : Date, val endTime : Date, val pause : Int)