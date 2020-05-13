package com.example.werk.klassen

import java.time.LocalDateTime

data class TicketJPOverview (val customer: Customer, val beginTime : LocalDateTime, val endTime : LocalDateTime, val pause : Int)