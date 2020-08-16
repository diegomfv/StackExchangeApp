package com.diegofajardo.stackexchangeapp.testdi

import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase

object TestUsecaseModule {
    val fakeGetUsersUsecase by lazy { GetUsersUsecase(TestDataModule.fakeUserRepository) }
}