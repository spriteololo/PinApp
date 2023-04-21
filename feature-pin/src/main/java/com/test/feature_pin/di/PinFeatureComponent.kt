package com.test.feature_pin.di

import com.test.feature_pin.di.module.PinModule
import dagger.Component

@Component(
    dependencies = [
        PinFeatureDependenciesComponent::class,
    ],
    modules = [
        PinModule::class,
    ]
)
internal abstract class PinFeatureComponent : PinFeatureApi {
    @Component.Factory
    interface ComponentFactory {

        fun create(dependencies: PinFeatureDependenciesComponent): PinFeatureComponent
    }

    companion object {

        fun get(): PinFeatureComponent {
            return DaggerPinFeatureComponent.factory().create(dependencies())
        }

        private fun dependencies(): PinFeatureDependenciesComponent {
            return DaggerPinFeatureDependenciesComponent.builder().build()
        }
    }
}

@Component
internal interface PinFeatureDependenciesComponent : PinDependencies