package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.ui.detail.DetailActivityViewModel
import com.diegofajardo.stackexchangeapp.ui.main.MainActivityViewModel
import com.diegofajardo.stackexchangeapp.ui.main.adapter.UsersAdapterUiManagerImpl

/** Interface for the components that the service locator will use to inject dependencies.
 * Abstracting the components we can use a test component in the test application
 * for running ui tests.
 * */
interface DIComponentImpl {
    fun provideMainActivityViewModelFactory(): MainActivityViewModel.Factory
    fun provideDetailActivityViewModelFactory(user: User): DetailActivityViewModel.Factory
    fun provideUsersAdapterUiManagerImpl(): UsersAdapterUiManagerImpl
}