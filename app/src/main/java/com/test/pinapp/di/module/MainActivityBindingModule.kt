package com.test.pinapp.di.module

import com.test.core_base.common.RootNavigator
import com.test.pinapp.navigator.RootNavigatorImpl
import dagger.Binds
import dagger.Module

@Module
internal interface MainActivityBindingModule {

    @Binds
    fun bindNavigator(navigator: RootNavigatorImpl): RootNavigator

}