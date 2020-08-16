package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.data.repository.UserRepository
import com.diegofajardo.stackexchangeapp.data.source.server.StackExchangeRemoteDataSource
import com.diegofajardo.stackexchangeapp.data.source.server.adapter.GetUsersQueryAdapter

object DataModule {

    val userRepository by lazy { UserRepository(remoteDataSource) }

    private val remoteDataSource by lazy { StackExchangeRemoteDataSource(getUsersQueryAdapter) }

    private val getUsersQueryAdapter by lazy { GetUsersQueryAdapter(NetworkModule.stackExchangeServerEndpoints) }
}