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

    fun calculateResult() : Long? {
        if (beginTime == null || beginTime!! <= 0) return 0
        if (endTime == null || endTime!! <= 0) return 0
        return endTime!! - beginTime!! - pause
    }
}