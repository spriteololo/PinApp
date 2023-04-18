package com.test.core_base.di.module

import com.test.core_base.streams.DispatcherProvider
import dagger.Binds
import dagger.Module

@Module
interface DispatcherProviderBindingModule {

    @Binds
    fun bindDispatcherProvider(dispatcherProvider: DispatcherProvider.Impl): DispatcherProvider
}