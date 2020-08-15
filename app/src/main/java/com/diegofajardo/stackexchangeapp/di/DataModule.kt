package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.data.repository.UserRepository
import com.diegofajardo.stackexchangeapp.data.source.server.StackExchangeRemoteDataSource

object DataModule {

    val userRepository by lazy { UserRepository(remoteDataSource) }
    private val remoteDataSource by lazy { StackExchangeRemoteDataSource() }

}