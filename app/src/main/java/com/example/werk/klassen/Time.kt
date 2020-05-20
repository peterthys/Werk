package com.example.werk.klassen

import java.sql.Date

class Time {

    var beginTime : Date? = null
    var endTime : Date? = null


    constructor(beginTime: Date, endTime: Date){
        this.beginTime = beginTime
        this.endTime = endTime

    }

}