package com.example.werk.klassen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "jobPerformance_table")
data class JobPerformance (
    @PrimaryKey (autoGenerate = true)
    var id : Int,
    @ColumnInfo (name = "tableCustomer")
    var tableCustomer : String,
    @ColumnInfo (name = "tableBeginTime")
    val tableBeginTime: LocalDateTime,
    @ColumnInfo (name = "tableEndTime")
    val tableEndTime: LocalDateTime,
    @ColumnInfo (name = "tablePause")
    val tablePause: LocalDateTime
){

}