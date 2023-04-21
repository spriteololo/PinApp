package com.test.feature_pin.di

import androidx.fragment.app.Fragment
import com.test.core_base.di.module.DispatcherProviderBindingModule
import com.test.core_pin.di.PinApi
import com.test.core_pin.domain.usecase.DeletePinUseCase
import com.test.core_pin.domain.usecase.GetPinUseCase
import com.test.core_pin.domain.usecase.ObservePinListUseCase
import com.test.core_pin.domain.usecase.SavePinUseCase
import com.test.core_pin_generator.di.PinGeneratorApi
import com.test.core_pin_generator.domain.usecase.GeneratePinUseCase
import com.test.feature_pin.di.module.PinScreenModule
import com.test.feature_pin.ui.PinListFragment
import dagger.Component

@Component(
    dependencies = [
        PinScreenDependenciesComponent::class
    ],
    modules = [
        PinScreenModule::class,
        DispatcherProviderBindingModule::class,
    ]
)
internal interface PinScreenComponent {

    fun inject(fragment: PinListFragment)

    @Component.Factory
    interface ComponentFactory {

        fun create(dependencies: PinScreenDependenciesComponent): PinScreenComponent
    }

    companion object {

        fun create(fragment: Fragment): PinScreenComponent {
            return DaggerPinScreenComponent.factory().create(dependencies(fragment))
        }

        private fun dependencies(fragment: Fragment): PinScreenDependenciesComponent {
            val application = fragment.requireActivity().application

            return DaggerPinScreenDependenciesComponent.builder()
                .pinApi(PinApi.get(application))
                .pinGeneratorApi(PinGeneratorApi.get())
                .build()
        }
    }
}

@Component(
    dependencies = [
        PinApi::class,
        PinGeneratorApi::class,
    ]
)
internal interface PinScreenDependenciesComponent : PinDependencies {

    fun observePinListUseCase(): ObservePinListUseCase

    fun savePinUseCase(): SavePinUseCase

    fun deletePinUseCase(): DeletePinUseCase

    fun getPinUseCase(): GetPinUseCase

    fun getGeneratePinUseCase(): GeneratePinUseCase
}