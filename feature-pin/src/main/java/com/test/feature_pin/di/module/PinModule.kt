package com.test.feature_pin.di.module

import com.test.feature_pin.navigator.PinListStarter
import com.test.feature_pin.navigator.PinListStarterImpl
import dagger.Binds
import dagger.Module

@Module
internal interface PinModule {

    @Binds
    fun bindPinListStarter(pinListStarterImpl: PinListStarterImpl): PinListStarter
}