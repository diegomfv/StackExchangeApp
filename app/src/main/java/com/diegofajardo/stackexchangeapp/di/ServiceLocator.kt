package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.App
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.ui.detail.DetailActivityViewModel
import com.diegofajardo.stackexchangeapp.ui.main.MainActivityViewModel
import com.diegofajardo.stackexchangeapp.ui.main.adapter.UsersAdapterUiManagerImpl

/**
 * Due to the size of the project I decided to use the Service Locator pattern instead of
 * a dependency injection tool like Dagger.
 * Allows to do assisted injection in an easy way.
 * See method 'provideDetailActivityViewModelFactory'.
 * */
object ServiceLocator {

    lateinit var app: App
        private set

    fun init (app: App) { this.app = app }

    ////

    fun provideMainActivityViewModelFactory () = MainActivityViewModel.Factory(
        app = app,
        getUsersUsecase = UsecaseModule.usersUsecase,
        schedulerProvider = RxModule.schedulerProvider,
        errorMapper = UtilsModule.provideErrorMapper(app)
    )

    fun provideDetailActivityViewModelFactory (user: User) = DetailActivityViewModel.Factory(
        app = app,
        user = user
    )

    fun provideUsersAdapterUiManagerImpl () : UsersAdapterUiManagerImpl {
        return UiModule.provideUsersAdapterUiManagerImpl()
    }

}