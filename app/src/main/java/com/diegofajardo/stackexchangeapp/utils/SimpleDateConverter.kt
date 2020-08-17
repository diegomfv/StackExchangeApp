package com.diegofajardo.stackexchangeapp.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

interface StackExchangeDateConverter {
    fun getDateAsString(creationDate: Long): String
}

class SimpleDateConverter : StackExchangeDateConverter {
    private val datePattern = "dd-MM-yyyy"
    private val dateFormat = SimpleDateFormat(datePattern, Locale.getDefault())
    override fun getDateAsString(creationDate: Long): String {
        return dateFormat.format(Date(creationDate))
    }
}