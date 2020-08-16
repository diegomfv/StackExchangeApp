package com.diegofajardo.stackexchangeapp.utils

import org.junit.Assert.assertTrue
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class SimpleDateConverterTest {

    @Test
    fun `getDateAsString when conversion is successful string pattern matches DATE_PATTERN format`() {
        val dateAsLong = 1304684964L
        val dateAsString = SimpleDateConverter(
            SimpleDateFormat("dd-mm-yyyy", Locale.getDefault())
        ).getDateAsString(dateAsLong)
        assertTrue(dateAsString[0] != '-')
        assertTrue(dateAsString[1] != '-')
        assertTrue(dateAsString[2] == '-')
        assertTrue(dateAsString[3] != '-')
        assertTrue(dateAsString[4] != '-')
        assertTrue(dateAsString[5] == '-')
        assertTrue(dateAsString[6] != '-')
        assertTrue(dateAsString[7] != '-')
        assertTrue(dateAsString[8] != '-')
        assertTrue(dateAsString[9] != '-')
    }
}