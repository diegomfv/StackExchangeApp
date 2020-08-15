package com.diegofajardo.stackexchangeapp.usecase

import com.diegofajardo.stackexchangeapp.data.server.model.QueryModel
import com.diegofajardo.stackexchangeapp.domain.User
import io.reactivex.Observable

class GetUsersUsecase (
    //dependency: repository
) {

    fun invoke (query: QueryModel) : Observable<User> {
        //return repo.getUsers...
        return Observable.fromIterable(listOf<User>(
            User("username1","111"),
            User("username2","222"),
            User("username3","333")
        ))
    }
}