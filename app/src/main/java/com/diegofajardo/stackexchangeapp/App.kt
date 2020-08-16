package com.diegofajardo.stackexchangeapp

import androidx.multidex.BuildConfig
import androidx.multidex.MultiDexApplication
import com.diegofajardo.stackexchangeapp.di.ServiceLocator
import timber.log.Timber

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        ServiceLocator.init(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}