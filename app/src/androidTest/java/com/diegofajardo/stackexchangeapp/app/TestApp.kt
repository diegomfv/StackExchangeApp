package com.diegofajardo.stackexchangeapp.app

import android.app.Application
import com.diegofajardo.stackexchangeapp.di.ServiceLocator
import com.diegofajardo.stackexchangeapp.uitestdi.TestComponent

/** Test application that will ran in all UiTests
 * */
class TestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceLocator.init(this, TestComponent(this))
    }

}