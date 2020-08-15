package com.diegofajardo.stackexchangeapp.utils

import io.reactivex.Scheduler

interface SchedulerProviderImpl {
    val androidScheduler: Scheduler
    val ioScheduler: Scheduler
    val computationScheduler: Scheduler
}

class SchedulerProvider (
    override val androidScheduler: Scheduler,
    override val ioScheduler: Scheduler,
    override val computationScheduler: Scheduler
) : SchedulerProviderImpl