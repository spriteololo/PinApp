package com.test.pinapp.di

import com.test.core_base.common.RootNavigator
import com.test.pinapp.PinApplication
import com.test.pinapp.di.module.MainActivityBindingModule
import com.test.pinapp.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Component(
    dependencies = [
        ActivityScreenComponentDependencies::class,
    ],
    modules = [
        MainActivityBindingModule::class,
    ]
)
internal interface MainActivityComponent {

    fun navigator(): RootNavigator

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance activity: MainActivity,
            dependencies: ActivityScreenComponentDependencies,
        ): MainActivityComponent
    }

    companion object {

        fun create(application: PinApplication, activity: MainActivity): MainActivityComponent {
            return DaggerMainActivityComponent.factory().create(activity, dependencies(application))
        }

        private fun dependencies(application: PinApplication): ActivityScreenComponentDependencies {

            return DaggerActivityScreenComponentDependencies.builder()
                .appComponent(application.appComponent)
                .build()
        }
    }
}

@Component(
    dependencies = [
        AppComponent::class,
    ]
)
internal interface ActivityScreenComponentDependencies {

    fun applicationScope(): CompositeDisposable
}
