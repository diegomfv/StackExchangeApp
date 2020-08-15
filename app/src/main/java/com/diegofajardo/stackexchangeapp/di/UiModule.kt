package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.ui.main.adapter.UsersAdapterUiManager
import com.diegofajardo.stackexchangeapp.ui.main.adapter.UsersAdapterUiManagerImpl

object UiModule {

    fun provideUsersAdapterUiManagerImpl () : UsersAdapterUiManagerImpl {
        return UsersAdapterUiManager()
    }

}