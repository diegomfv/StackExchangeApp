package com.diegofajardo.stackexchangeapp

import android.app.Application
import com.diegofajardo.stackexchangeapp.di.ServiceLocator
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceLocator.init(this)
        if (BuildConfig.DEBUG) { Timber.plant(Timber.DebugTree()) }
    }

}