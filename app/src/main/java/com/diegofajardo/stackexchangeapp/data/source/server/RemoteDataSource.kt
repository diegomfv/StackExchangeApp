package com.diegofajardo.stackexchangeapp.data.source.server

import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.domain.User
import io.reactivex.Observable

interface RemoteDataSource {
    fun getUsers(queryModel: QueryModel): Observable<User>
}