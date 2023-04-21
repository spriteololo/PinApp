package com.test.pinapp

import android.app.Application
import com.test.core_base.common.BaseApi
import com.test.pinapp.di.AppComponent
import com.test.pinapp.di.AppComponentImpl
import io.reactivex.rxjava3.disposables.CompositeDisposable

class PinApplication : Application(), BaseApi {

    internal lateinit var appComponent: AppComponent

    private val applicationScope = CompositeDisposable()

    override fun compositeDisposable(): CompositeDisposable {
        return applicationScope
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponentImpl.create(
            application = this,
            applicationScope = applicationScope,
        )
    }
}