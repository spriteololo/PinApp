package com.test.core_base.streams

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

interface DispatcherProvider {

    val computation: Scheduler
    val io: Scheduler
    val main: Scheduler

    class Impl @Inject constructor() : DispatcherProvider {

        override val computation: Scheduler
            get() = Schedulers.computation()
        override val io: Scheduler
            get() = Schedulers.io()
        override val main: Scheduler
            get() = AndroidSchedulers.mainThread()
    }
}