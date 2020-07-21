package com.example.werk.klassen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_table")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "customerName")
    var customerName: String = "",
    @ColumnInfo(name = "customerDescription")
    var customerDescription: String = "",
    @ColumnInfo(name = "customerPhone")
    var customerPhone: String = "",
    @ColumnInfo(name = "customerEmail")
    var customerEmail: String = "",
    @ColumnInfo(name = "customerAdress1")
    var customerAdress1: String = "",
    @ColumnInfo(name = "customerAdress2")
    var customerAdress2: String = "",
    @ColumnInfo(name = "customerInfo")
    var customerInfo: String = "",
    @ColumnInfo(name = "customerBTWnr")
    var customerBTWnr: String = ""
) 
