package com.diegofajardo.stackexchangeapp.utils

import com.diegofajardo.stackexchangeapp.R
import com.diegofajardo.stackexchangeapp.di.ServiceLocator

interface ErrorMapper {
    fun getErrorMessage (throwable: Throwable?) : String
}

class SimpleErrorMapper : ErrorMapper {

    override fun getErrorMessage(throwable: Throwable?): String {
        return throwable?.message
            ?: ServiceLocator.app.getString(R.string.error_message_not_available)
    }
}