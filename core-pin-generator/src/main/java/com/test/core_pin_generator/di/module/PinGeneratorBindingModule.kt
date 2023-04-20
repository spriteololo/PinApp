package com.test.core_pin_generator.di.module

import com.test.core_pin_generator.data.PinGeneratorImpl
import com.test.core_pin_generator.domain.PinGenerator
import com.test.core_pin_generator.domain.usecase.GeneratePinUseCase
import com.test.core_pin_generator.domain.usecase.GeneratePinUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface PinGeneratorBindingModule {

    @Binds
    fun bindGeneratePinUseCase(impl: GeneratePinUseCaseImpl): GeneratePinUseCase

    @Binds
    fun bindPinGenerator(impl: PinGeneratorImpl): PinGenerator
}