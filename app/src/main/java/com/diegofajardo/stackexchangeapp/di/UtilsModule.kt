package com.diegofajardo.stackexchangeapp.di

import android.app.Application
import com.diegofajardo.stackexchangeapp.utils.*
import java.text.SimpleDateFormat
import java.util.*

object UtilsModule {

    fun provideErrorMapper(app: Application): ErrorMapper {
        return SimpleErrorMapper(app)
    }

    fun provideDateConverter(): StackExchangeDateConverter {
        return SimpleDateConverter()
    }

    fun provideOnlyInnameQueryBuilder(): QueryBuilder {
        return OnlyInnameQueryBuilder()
    }

}