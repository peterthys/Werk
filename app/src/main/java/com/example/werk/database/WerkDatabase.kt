package com.example.werk.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.werk.klassen.Customer
import com.example.werk.klassen.JobPerformance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*


@Database(
    entities = [JobPerformance::class, Customer::class],
    version = 6,
    exportSchema = false
)
@TypeConverters(DatabaseConverters::class)
abstract class WerkDatabase : RoomDatabase() {

    abstract fun jobPerformanceDao(): JobPerformanceDao
    abstract fun customersDao(): CustomersDao

    private class WerkDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    // Customers
                    populateCustomers(database.customersDao())

                    // Job Performances
                    populateJobPerformances(database.jobPerformanceDao())
                }
            }
        }

        suspend fun populateCustomers(customersDao: CustomersDao) {
            customersDao.deleteAll()
            customersDao.insert(Customer("Keulemans", "015234578"))
            customersDao.insert(Customer("Thys", "04789562"))
        }

        suspend fun populateJobPerformances(jobPerformanceDao : JobPerformanceDao) {
            jobPerformanceDao.deleteAll()

            val begintijd1 = Calendar.getInstance().time
            val jobPerformance1 = JobPerformance(1, 1, begintijd1, begintijd1, 240)
            jobPerformanceDao.insert(jobPerformance1)

            val begintijd2 = Calendar.getInstance().time
            val jobPerformance2 = JobPerformance(2, 2, begintijd2, begintijd2, 240)
            jobPerformanceDao.insert(jobPerformance2)
        }

    }


    companion object {

        @Volatile
        private var INSTANCE: WerkDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): WerkDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WerkDatabase::class.java,
                    "werk_database"
                )
                    .addCallback(WerkDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}