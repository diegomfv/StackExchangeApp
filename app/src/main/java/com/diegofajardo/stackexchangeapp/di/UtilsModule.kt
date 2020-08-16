package com.diegofajardo.stackexchangeapp.di

import android.app.Application
import com.diegofajardo.stackexchangeapp.utils.ErrorMapper
import com.diegofajardo.stackexchangeapp.utils.SimpleErrorMapper

object UtilsModule {

    fun provideErrorMapper(app: Application): ErrorMapper {
        return SimpleErrorMapper(app)
    }

}