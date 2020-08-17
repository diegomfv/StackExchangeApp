package com.diegofajardo.stackexchangeapp.utils

import org.junit.Assert.assertTrue
import org.junit.Test

class SimpleDateConverterTest {

    @Test
    fun `getDateAsString when conversion is successful string pattern matches DATE_PATTERN format`() {
        val dateAsLong = 1596875400L
        val dateAsString = SimpleDateConverter().getDateAsString(dateAsLong)
        assertTrue(dateAsString == "19-01-1970")
    }
}