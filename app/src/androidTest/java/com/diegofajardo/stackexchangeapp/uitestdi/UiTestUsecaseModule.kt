package com.diegofajardo.stackexchangeapp.uitestdi

import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase

object UiTestUsecaseModule {
    val fakeGetUsersUsecase by lazy { GetUsersUsecase(UiTestDataModule.fakeUserRepository) }
}