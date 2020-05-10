package com.example.werk.klassen

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(JobPerformance::class), version = 1, exportSchema = false)
public abstract class JobPerformanceDatabase : RoomDatabase() {

    abstract fun wordDao(): JobPerformanceDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: JobPerformanceDatabase? = null

        fun getDatabase(context: Context): JobPerformanceDatabase {
            val tempInstance = INSTANCE
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