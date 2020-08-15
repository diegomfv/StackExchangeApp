package com.diegofajardo.stackexchangeapp.usecase

import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.data.repository.UserRepository
import com.diegofajardo.stackexchangeapp.domain.User
import io.reactivex.Observable

class GetUsersUsecase (
    private val userRepository: UserRepository
) {

    fun invoke (queryModel: QueryModel) : Observable<User> {
        return userRepository.getUsers(queryModel)
    }
}