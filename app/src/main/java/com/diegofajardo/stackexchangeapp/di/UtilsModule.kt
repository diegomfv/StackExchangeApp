package com.diegofajardo.stackexchangeapp.di

import android.app.Application
import com.diegofajardo.stackexchangeapp.utils.ErrorMapper
import com.diegofajardo.stackexchangeapp.utils.SimpleDateConverter
import com.diegofajardo.stackexchangeapp.utils.SimpleErrorMapper
import com.diegofajardo.stackexchangeapp.utils.StackExchangeDateConverter
import java.text.SimpleDateFormat
import java.util.*

object UtilsModule {

    fun provideErrorMapper(app: Application): ErrorMapper {
        return SimpleErrorMapper(app)
    }

    fun provideDateConverter(): StackExchangeDateConverter {
        val datePattern = "dd-mm-yyyy"
        return SimpleDateConverter(SimpleDateFormat(datePattern, Locale.getDefault()))
    }

}