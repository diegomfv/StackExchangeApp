package com.diegofajardo.stackexchangeapp.utils

import android.app.Application
import com.diegofajardo.stackexchangeapp.R

interface ErrorMapper {
    fun getErrorMessage(throwable: Throwable?): String
}

class SimpleErrorMapper(
    private val app: Application
) : ErrorMapper {

    override fun getErrorMessage(throwable: Throwable?): String {
        return throwable?.message
            ?: app.getString(R.string.error_message_not_available)
    }
}