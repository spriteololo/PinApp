package com.test.feature_pin.di.module

import dagger.Module

@Module(
    includes = [
        PinBindingModule::class
    ]
)
internal interface PinScreenModule
