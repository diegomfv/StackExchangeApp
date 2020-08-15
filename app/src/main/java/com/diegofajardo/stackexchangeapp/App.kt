package com.diegofajardo.stackexchangeapp

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        AppProvider.init(this)
    }

}