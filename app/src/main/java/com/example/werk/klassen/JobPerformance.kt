package com.example.werk.klassen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jobPerformance_table")
data class JobPerformance (
    @PrimaryKey (autoGenerate = true)
    var id : Int=0,
    @ColumnInfo (name = "customerId")
    var customerName : String,
    @ColumnInfo (name = "beginTime")
    var beginTime: Long?,
    @ColumnInfo (name = "endTime")
    var endTime: Long?,
    @ColumnInfo (name = "pause")
    var pause: Int

)