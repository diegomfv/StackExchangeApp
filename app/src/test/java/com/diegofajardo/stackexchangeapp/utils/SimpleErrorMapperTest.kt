package com.diegofajardo.stackexchangeapp.utils

import android.os.Build
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class SimpleErrorMapperTest {

    @Test
    fun `getErrorMessage when throwable_message is null returns Error message not available`() {
        val errorMapper = SimpleErrorMapper(ApplicationProvider.getApplicationContext())
        val errorMessage = errorMapper.getErrorMessage(Throwable(message = null))
        assertTrue(errorMessage == "Error message not available")
    }

    @Test
    fun `getErrorMessage when throwable_message is not null returns throwable_message`() {
        val errorMapper = SimpleErrorMapper(ApplicationProvider.getApplicationContext())
        val errorMessage = errorMapper.getErrorMessage(Throwable(message = "Error message"))
        assertTrue(errorMessage == "Error message")
    }
}