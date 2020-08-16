package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.data.source.server.endpoint.StackExchangeServerEndpoints
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private val baseUrl by lazy { "https://api.stackexchange.com/2.2/" }

    private val rxJava2CallAdapterFactory by lazy { RxJava2CallAdapterFactory.create() }

    private val gsonConverterFactory by lazy { GsonConverterFactory.create() }

    val stackExchangeServerEndpoints : StackExchangeServerEndpoints by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .run {
                create<StackExchangeServerEndpoints>(
                    StackExchangeServerEndpoints::class.java
                )
            }
    }
}