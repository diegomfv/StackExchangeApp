package com.diegofajardo.stackexchangeapp.di

import android.app.Application
import com.diegofajardo.stackexchangeapp.domain.User

/**
 * Due to the size of the project I decided to use the Service Locator pattern instead of
 * a dependency injection tool like Dagger.
 * Allows to do assisted injection in an easy way.
 * See method 'provideDetailActivityViewModelFactory'.
 * */
object ServiceLocator {

    lateinit var app: Application
        private set

    lateinit var diComponentImpl: DIComponentImpl
        private set

    fun init(app: Application, DIComponentImpl: DIComponentImpl) {
        this.app = app
        this.diComponentImpl = DIComponentImpl
    }

    ////

    fun provideMainActivityViewModelFactory() = diComponentImpl.provideMainActivityViewModelFactory()

    fun provideDetailActivityViewModelFactory(user: User) = diComponentImpl.provideDetailActivityViewModelFactory(user)

    fun provideUsersAdapterUiManagerImpl() = diComponentImpl.provideUsersAdapterUiManagerImpl()

}