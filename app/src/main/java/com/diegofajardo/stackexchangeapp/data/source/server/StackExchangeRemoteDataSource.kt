package com.diegofajardo.stackexchangeapp.data.source.server

import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.data.source.server.adapter.GetUsersQueryAdapter
import com.diegofajardo.stackexchangeapp.data.toDomainUser
import com.diegofajardo.stackexchangeapp.domain.User
import io.reactivex.Observable

class StackExchangeRemoteDataSource(
    private val getUsersQueryAdapter: GetUsersQueryAdapter
) : RemoteDataSource {

    override fun getUsers(queryModel: QueryModel): Observable<User> {
        return getUsersQueryAdapter.getUsers(queryModel)
            .flatMapIterable { it.users }
            .map { it.toDomainUser() }
    }
}