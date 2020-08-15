package com.diegofajardo.stackexchangeapp.data.repository

import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.data.source.server.RemoteDataSource
import com.diegofajardo.stackexchangeapp.domain.User
import io.reactivex.Observable

class UserRepository (
    private val remoteDataSource: RemoteDataSource
) {

    fun getUsers (queryModel: QueryModel) : Observable<User> {
        return remoteDataSource.getUsers(queryModel)
    }

}