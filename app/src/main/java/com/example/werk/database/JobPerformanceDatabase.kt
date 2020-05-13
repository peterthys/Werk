package com.example.werk.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.werk.klassen.Customer
import com.example.werk.klassen.JobPerformance

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(JobPerformance::class, Customer::class), version = 4, exportSchema = false)
@TypeConverters(DatabaseConverters::class)
public abstract class JobPerformanceDatabase : RoomDatabase() {

    abstract fun jobPerformanceDao(): JobPerformanceDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: JobPerformanceDatabase? = null

        fun getDatabase(context: Context): JobPerformanceDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, JobPerformanceDatabase::class.java, "word_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}