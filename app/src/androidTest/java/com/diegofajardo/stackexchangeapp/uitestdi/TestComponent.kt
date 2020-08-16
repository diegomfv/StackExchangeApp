package com.diegofajardo.stackexchangeapp.uitestdi

import android.app.Application
import com.diegofajardo.stackexchangeapp.di.DIComponentImpl
import com.diegofajardo.stackexchangeapp.di.RxModule
import com.diegofajardo.stackexchangeapp.di.UiModule
import com.diegofajardo.stackexchangeapp.di.UtilsModule
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.ui.detail.DetailActivityViewModel
import com.diegofajardo.stackexchangeapp.ui.main.MainActivityViewModel
import com.diegofajardo.stackexchangeapp.ui.main.adapter.UsersAdapterUiManagerImpl
import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase

class TestComponent(private val app: Application) : DIComponentImpl {

    private fun provideFakeGetUsersUsecase(): GetUsersUsecase {
        return UiTestUsecaseModule.fakeGetUsersUsecase
    }

    override fun provideMainActivityViewModelFactory() = MainActivityViewModel.Factory(
        app = app,
        getUsersUsecase = provideFakeGetUsersUsecase(),
        schedulerProvider = RxModule.schedulerProvider,
        errorMapper = UtilsModule.provideErrorMapper(
            app
        )
    )

    override fun provideDetailActivityViewModelFactory(user: User) =
        DetailActivityViewModel.Factory(
            app = app,
            dateConverter = UtilsModule.provideDateConverter(),
            user = user
        )

    override fun provideUsersAdapterUiManagerImpl(): UsersAdapterUiManagerImpl {
        return UiModule.provideUsersAdapterUiManagerImpl()
    }
}