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
import kotlin.reflect.KParameter

//https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#11
@Database(
    entities = arrayOf(JobPerformance::class, Customer::class),
    version = 5,
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
            KParameter.Kind.INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.JobPerformanceDao)
                    var jobPerformanceDao = database.jobPerformanceDao()
                    suspend fun populateDatabase(
                        jobPerformanceDao: JobPerformanceDao,
                        customer: Customer
                    ) {
                        jobPerformanceDao.deleteJobPerformance()
                        customerDao.deleteCustomer()
                        var begintijd = Calendar.getInstance().time
                        var eindtijd = begintijd
                        var jobPerformance = JobPerformance(2, 2, begintijd, eindtijd, 240)
                    }
                }
            }


        }

    }




companion object {

    @Volatile
    private var INSTANCE ?: WerkDatabase? = null

    fun getDatabase(
        context: Context,
        scope: CoroutineScope
    ):
            WerkDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }
        return INSTANCE ? : synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                WerkDatabase::class.java,
                "werk_database"
            ) addCallback (WerkDatabase(scope)
                .build()
                    INSTANCE = instance
                    return instance
        }
    }
}
}