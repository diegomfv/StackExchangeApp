package com.diegofajardo.stackexchangeapp.runner

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.diegofajardo.stackexchangeapp.app.TestApp

class UiTestRunner : AndroidJUnitRunner() {
    @Throws(
        InstantiationException::class,
        IllegalAccessException::class,
        ClassNotFoundException::class
    )
    override fun newApplication(
        cl: ClassLoader,
        className: String,
        context: Context
    ): Application {
        return super.newApplication(cl, TestApp::class.java.getName(), context)
    }
}