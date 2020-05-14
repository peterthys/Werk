package com.example.werk.klassen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_table")
data class Customer (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "customerId")
    var customerID : Int  ,
    @ColumnInfo (name = "customerName")
    var customerName : String,
    @ColumnInfo (name = "customerDescription")
    var customerDescription : String,
    @ColumnInfo (name = "customerPhone")
    var customerPhone : String,
@ColumnInfo (name = "customerEmail")
    var customerEmail : String ,
@ColumnInfo (name = "customerAdress1")
    var customerAdress1 : String,
@ColumnInfo (name = "customerAdress2")
    var customerAdress2 : String ?,
@ColumnInfo (name = "customerInfo")
    var customerInfo : String ,
@ColumnInfo (name = "ccustomerBTWnr")
    var customerBTWnr : String ,
)

//    constructor(customerID : Int, customerName :String, customerDesecription : String,customerPhone : String, customerEmail :String,customerAdress1 : String,
//                customerAdress2 : String,customerInfo : String ,customerBTWnr : String){
//        this.customerID = customerID
//        this.customerName = customerName
//        this.customerDescription = customerDesecription
//        this.customerPhone = customerPhone
//        this.customerEmail = customerEmail
//        this.customerAdress1 = customerAdress1
//        this.customerAdress2 = customerAdress2
//        this.customerInfo = customerInfo
//        this.customerBTWnr = customerBTWnr
//    }

