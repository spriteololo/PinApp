package com.test.core_pin.di

import android.content.Context
import com.test.core_pin.domain.usecase.DeletePinUseCase
import com.test.core_pin.domain.usecase.ObservePinListUseCase
import com.test.core_pin.domain.usecase.SavePinUseCase

interface PinApi {

    fun observePinListUseCase(): ObservePinListUseCase

    fun savePinUseCase(): SavePinUseCase

    fun deletePinUseCase(): DeletePinUseCase

    companion object {

        fun get(appContext: Context): PinApi {
            return PinComponent.get(appContext)
        }
    }
}