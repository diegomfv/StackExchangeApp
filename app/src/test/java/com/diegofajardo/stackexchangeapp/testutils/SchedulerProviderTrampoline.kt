package com.diegofajardo.stackexchangeapp.testutils

import com.diegofajardo.stackexchangeapp.utils.SchedulerProviderImpl
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class SchedulerProviderTrampoline : SchedulerProviderImpl {
    override val androidScheduler: Scheduler = Schedulers.trampoline()
    override val ioScheduler: Scheduler = Schedulers.trampoline()
    override val computationScheduler: Scheduler = Schedulers.trampoline()
}