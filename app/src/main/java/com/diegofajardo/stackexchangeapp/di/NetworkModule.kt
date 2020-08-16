package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.data.source.server.endpoint.StackExchangeServerEndpoints
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private val baseUrl by lazy { "https://api.stackexchange.com/2.2/" }

    private val rxJava2CallAdapterFactory by lazy { RxJava2CallAdapterFactory.create() }

    private val gsonConverterFactory by lazy { GsonConverterFactory.create() }

    private val okHttpClient by lazy {
        HttpLoggingInterceptor().run {
            level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(this).build()
        }
    }

    val stackExchangeServerEndpoints : StackExchangeServerEndpoints by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
            .run {
                create<StackExchangeServerEndpoints>(
                    StackExchangeServerEndpoints::class.java
                )
            }
    }
}