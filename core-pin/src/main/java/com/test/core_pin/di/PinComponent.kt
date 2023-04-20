package com.test.core_pin.di

import android.content.Context
import com.test.core_base.di.module.DispatcherProviderBindingModule
import com.test.core_pin.di.module.PinBindingModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        PinDependenciesComponent::class,
    ],
    modules = [
        PinBindingModule::class,
        DispatcherProviderBindingModule::class,
    ]
)
@Singleton
internal interface PinComponent : PinApi {

    @Component.Factory
    interface ComponentFactory {

        fun create(
            @BindsInstance applicationContext: Context,
            dependencies: PinDependenciesComponent,
        ): PinComponent
    }

    companion object {

        private var cachedComponent: PinComponent? = null

        fun get(
            applicationContext: Context,
        ): PinComponent {
            return cachedComponent ?: DaggerPinComponent.factory().create(
                applicationContext,
                dependencies(),
            ).also { component ->
                cachedComponent = component
            }
        }

        private fun dependencies(): PinDependenciesComponent {
            return DaggerPinDependenciesComponent.builder()
                .build()
        }
    }
}

@Component
internal interface PinDependenciesComponent