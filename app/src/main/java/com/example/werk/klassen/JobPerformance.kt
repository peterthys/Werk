package com.example.werk.klassen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "jobPerformance_table")
data class JobPerformance (
    @PrimaryKey (autoGenerate = true)
    var id : Int,
    @ColumnInfo (name = "customerId")
    var customerId : Int,
    @ColumnInfo (name = "beginTime")
    val beginTime: LocalDateTime,
    @ColumnInfo (name = "endTime")
    val endTime: LocalDateTime,
    @ColumnInfo (name = "pause")
    val pause: Int
){

}