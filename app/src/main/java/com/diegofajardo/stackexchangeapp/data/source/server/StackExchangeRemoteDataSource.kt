package com.diegofajardo.stackexchangeapp.data.source.server

import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.domain.User
import io.reactivex.Observable

class StackExchangeRemoteDataSource : RemoteDataSource {

    override fun getUsers(query: QueryModel): Observable<User> {
        return Observable.fromIterable(listOf<User>(
            User("username1","111"),
            User("username2","222"),
            User("username3","333")
        ))
    }
}