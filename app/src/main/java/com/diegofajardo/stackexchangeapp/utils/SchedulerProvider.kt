package com.diegofajardo.stackexchangeapp.utils

import io.reactivex.Scheduler

class SchedulerProvider (
    val androidScheduler: Scheduler,
    val ioScheduler: Scheduler,
    val computationScheduler: Scheduler
)