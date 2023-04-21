package com.test.pinapp.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Singleton

@Component
@Singleton
interface AppComponentImpl : AppComponent {

    @Component.Factory
    interface ComponentFactory {

        fun create(
            @BindsInstance context: Context,
            @BindsInstance applicationScope: CompositeDisposable,
        ): AppComponent
    }

    companion object {

        fun create(
            application: Application,
            applicationScope: CompositeDisposable,
        ): AppComponent {
            return DaggerAppComponentImpl.factory().create(
                context = application,
                applicationScope = applicationScope,
            )
        }
    }
}

interface AppComponent {

    fun applicationScope(): CompositeDisposable
}
