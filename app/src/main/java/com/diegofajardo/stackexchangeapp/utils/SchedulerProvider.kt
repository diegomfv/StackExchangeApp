package com.diegofajardo.stackexchangeapp.utils

import io.reactivex.Scheduler

class SchedulerProvider (
    val androidScheduler: Scheduler,
    val subscribeScheduler: Scheduler,
    val observerScheduler: Scheduler
)