package com.diegofajardo.stackexchangeapp

object AppProvider {

    lateinit var app: App
        private set

    fun init (app: App) { this.app = app }

}