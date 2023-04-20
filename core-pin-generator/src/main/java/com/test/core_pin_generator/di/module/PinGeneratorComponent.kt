package com.test.core_pin_generator.di.module

import com.test.core_pin_generator.di.PinGeneratorApi
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        PinGeneratorComponentDependencies::class,
    ],
    modules = [
        PinGeneratorBindingModule::class,
    ]
)
@Singleton
internal interface PinGeneratorComponent : PinGeneratorApi {

    @Component.Factory
    interface ComponentFactory {

        fun create(
            dependencies: PinGeneratorComponentDependencies,
        ): PinGeneratorComponent
    }

    companion object {
        fun get(): PinGeneratorComponent {
            return DaggerPinGeneratorComponent.factory().create(dependencies())
        }

        private fun dependencies(): PinGeneratorComponentDependencies {
            return DaggerPinGeneratorComponentDependencies.builder()
                .build()
        }
    }
}

@Component
internal interface PinGeneratorComponentDependencies