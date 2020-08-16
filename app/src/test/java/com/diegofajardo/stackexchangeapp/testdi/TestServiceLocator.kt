package com.diegofajardo.stackexchangeapp.testdi

import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase

object TestServiceLocator {

    fun provideFakeGetUsersUsecase () : GetUsersUsecase {
        return TestUsecaseModule.fakeGetUsersUsecase
    }




}