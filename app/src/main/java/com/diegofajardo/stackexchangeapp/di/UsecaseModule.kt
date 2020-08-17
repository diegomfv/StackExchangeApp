package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase

object UsecaseModule {

    val usersUsecase by lazy { GetUsersUsecase(DataModule.userRepository) }

}