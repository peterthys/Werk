package com.example.werk.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jobPerformance_table")
data class JobPerformance(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "customerId")
    var customerName: String,
    @ColumnInfo(name = "beginTime")
    var beginTime: Long?,
    @ColumnInfo(name = "endTime")
    var endTime: Long?,
    @ColumnInfo(name = "pause")
    var pause: Int
) {

    fun calculateResult(): String? {
        if (beginTime == null) return "0"
        if (endTime == null) return "0"
        val totalHours = (endTime!! - beginTime!! - pause)/3600000
        val totalMinutes = (endTime!! - beginTime!! - pause)/60000-(totalHours*60)
        return " ${totalHours} hour  ${totalMinutes} min."
    }
}