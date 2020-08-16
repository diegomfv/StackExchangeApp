package com.diegofajardo.stackexchangeapp.utils

import java.text.DateFormat
import java.util.*

interface StackExchangeDateConverter {
    fun getDateAsString(creationDate: Long): String
}

class SimpleDateConverter(private val dateFormat: DateFormat) : StackExchangeDateConverter {
    override fun getDateAsString(creationDate: Long): String {
        return dateFormat.format(Date(creationDate))
    }
}