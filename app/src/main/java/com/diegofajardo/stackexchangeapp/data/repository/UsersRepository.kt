package com.diegofajardo.stackexchangeapp.data.repository

import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.data.source.server.RemoteDataSource
import com.diegofajardo.stackexchangeapp.domain.User
import io.reactivex.Observable

/**
 * We use the repository to abstract the data source/s from the rest of the app.
 * */
class UserRepository(
    private val remoteDataSource: RemoteDataSource
    //private val localDataSource: LocalDataSource
) {

    fun getUsers(queryModel: QueryModel): Observable<User> {
        return remoteDataSource.getUsers(queryModel)
    }

}