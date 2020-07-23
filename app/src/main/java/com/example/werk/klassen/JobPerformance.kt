package com.example.werk.klassen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "jobPerformance_table")
data class JobPerformance (
    @PrimaryKey (autoGenerate = true)
    var id : Int,
    @ColumnInfo (name = "customerId")
    var customerId : Int,
    @ColumnInfo (name = "beginTime")
    val beginTime: Date?,
    @ColumnInfo (name = "endTime")
    val endTime: Date?,
    @ColumnInfo (name = "pause")
    val pause: Int

)