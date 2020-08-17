package com.diegofajardo.stackexchangeapp.di

import android.app.Application
import com.diegofajardo.stackexchangeapp.domain.User

/**
 * Due to the size of the project the Service Locator pattern is used instead of
 * a dependency injection tool like Dagger.
 * It uses an abstraction of components (@property DIComponentImpl) so that different
 * modules can be used in different applications.
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

    fun provideMainActivityViewModelFactory() =
        diComponentImpl.provideMainActivityViewModelFactory()

    /* This pattern allows to do assisted injection in an easy way */
    fun provideDetailActivityViewModelFactory(user: User) =
        diComponentImpl.provideDetailActivityViewModelFactory(user)

    fun provideUsersAdapterUiManagerImpl() = diComponentImpl.provideUsersAdapterUiManagerImpl()

}