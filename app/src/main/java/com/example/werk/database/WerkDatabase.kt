package com.example.werk.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.werk.klassen.Customer
import com.example.werk.klassen.JobPerformance

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(JobPerformance::class, Customer::class), version = 5, exportSchema = false)
@TypeConverters(DatabaseConverters::class)
public abstract class WerkDatabase : RoomDatabase() {

    abstract fun jobPerformanceDao(): JobPerformanceDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: WerkDatabase? = null

        fun getDatabase(context: Context): WerkDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, WerkDatabase::class.java,
                    "jobPerformance_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}