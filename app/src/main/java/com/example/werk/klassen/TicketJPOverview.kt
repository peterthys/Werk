package com.example.werk.klassen

import java.time.LocalDateTime
import java.util.*

data class TicketJPOverview (val customer: Customer, val beginTime : Date, val endTime : Date, val pause : Int)