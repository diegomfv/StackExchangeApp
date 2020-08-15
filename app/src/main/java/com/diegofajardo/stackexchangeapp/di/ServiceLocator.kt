package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.App

/**
 * Due to the size of the project I decided to use the Service Locator pattern instead of
 * a dependency injection tool like Dagger.
 * */
object ServiceLocator {

    lateinit var app: App
        private set

    fun init (app: App) { this.app = app }

}