package com.diegofajardo.stackexchangeapp.di

import com.diegofajardo.stackexchangeapp.utils.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RxModule {

    val schedulerProvider by lazy {
        SchedulerProvider(
            androidScheduler = AndroidSchedulers.mainThread(),
            ioScheduler = Schedulers.io(),
            computationScheduler = Schedulers.computation()
        )
    }

}