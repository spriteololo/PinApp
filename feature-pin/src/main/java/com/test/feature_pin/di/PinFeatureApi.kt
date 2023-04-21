package com.test.feature_pin.di

import com.test.feature_pin.navigator.PinListStarter

interface PinFeatureApi {

    fun pinListStarter(): PinListStarter

    companion object {

        fun get(): PinFeatureApi {
            return PinFeatureComponent.get()
        }
    }
}