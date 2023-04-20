package com.test.core_pin_generator.di

import com.test.core_pin_generator.di.module.PinGeneratorComponent
import com.test.core_pin_generator.domain.usecase.*

interface PinGeneratorApi {

    fun getGeneratePinUseCase(): GeneratePinUseCase

    companion object {

        fun get(): PinGeneratorApi {
            return PinGeneratorComponent.get()
        }
    }
}