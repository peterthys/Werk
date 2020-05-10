package com.example.werk.klassen

class Customer {
    var customerID : Int ? = null
    var customerName : String ? = null
    var customerDesecription : String ?= null
    var customerPhone : String ? = null
    var customerEmail : String ? = null
    var customerAdress1 : String ?= null
    var customerAdress2 : String ?= null
    var customerInfo : String ?= null
    var customerBTWnr : String ?= null

    constructor(customerID : Int, customerName :String, customerDesecription : String,customerPhone : String, customerEmail :String,customerAdress1 : String,
                customerAdress2 : String,customerInfo : String ,customerBTWnr : String){
        this.customerID = customerID
        this.customerName = customerName
        this.customerDesecription = customerDesecription
        this.customerPhone = customerPhone
        this.customerEmail = customerEmail
        this.customerAdress1 = customerAdress1
        this.customerAdress2 = customerAdress2
        this.customerInfo = customerInfo
        this.customerBTWnr = customerBTWnr
    }

}