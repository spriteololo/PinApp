package com.test.feature_pin.di.module

import com.test.feature_pin.domain.usecase.GenerateAndSaveNewPinUseCase
import com.test.feature_pin.domain.usecase.GenerateAndSaveNewPinUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface PinBindingModule {

    @Binds
    fun bindGenerateNewPinUseCase(impl: GenerateAndSaveNewPinUseCaseImpl): GenerateAndSaveNewPinUseCase
}
