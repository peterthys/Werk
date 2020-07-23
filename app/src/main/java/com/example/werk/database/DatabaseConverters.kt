package com.example.werk.database

import androidx.room.TypeConverter
import java.util.*

class DatabaseConverters {

    @TypeConverter
    fun fromLongToDate(value : Long?) : Date {
        return if (value == null) {
            Date(0)
        } else {
            Date(value)
        }
    }

    @TypeConverter
    fun fromDateToLong(value : Date?) : Long {
        return value?.time ?: 0
    }

}