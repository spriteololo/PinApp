package com.test.feature_pin.di.module

import com.test.feature_pin.domain.usecase.GenerateNewPinUseCase
import com.test.feature_pin.domain.usecase.GenerateNewPinUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface PinBindingModule {

    @Binds
    fun bindGenerateNewPinUseCase(impl: GenerateNewPinUseCaseImpl): GenerateNewPinUseCase
}
