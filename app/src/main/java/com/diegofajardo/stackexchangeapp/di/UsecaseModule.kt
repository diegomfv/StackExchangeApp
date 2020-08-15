package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase

object UsecaseModule {

    fun provideGetUsersUsecase () = GetUsersUsecase()

}