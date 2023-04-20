package com.test.core_pin.di.module

import com.test.core_pin.data.PinRepositoryImpl
import com.test.core_pin.domain.PinRepository
import com.test.core_pin.domain.usecase.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface PinBindingModule {

    @Binds
    @Singleton
    fun bindPinRepository(impl: PinRepositoryImpl): PinRepository

    @Binds
    fun bindObservePinListUseCase(impl: ObservePinListUseCaseImpl): ObservePinListUseCase

    @Binds
    fun bindSavePinUseCaseImpl(impl: SavePinUseCaseImpl): SavePinUseCase

    @Binds
    fun bindDeletePinUseCase(impl: DeletePinUseCaseImpl): DeletePinUseCase
}