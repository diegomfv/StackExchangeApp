package com.diegofajardo.stackexchangeapp.usecase

import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.data.repository.UserRepository
import com.diegofajardo.stackexchangeapp.domain.User
import io.reactivex.Observable

/**
 * Even though the usecase looks redundant I left it here as an example.
 * It allows to prepare the data for the viewmodel keeping the last one clean.
 * Additionally, we gain scalability.
 * */
class GetUsersUsecase(
    private val userRepository: UserRepository
) {

    fun invoke(queryModel: QueryModel): Observable<User> {
        return userRepository.getUsers(queryModel)
    }
}