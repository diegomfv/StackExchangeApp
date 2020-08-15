package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.utils.ErrorMapper
import com.diegofajardo.stackexchangeapp.utils.SimpleErrorMapper

object UtilsModule {

    fun provideErrorMapper () : ErrorMapper {
        return SimpleErrorMapper()
    }

}