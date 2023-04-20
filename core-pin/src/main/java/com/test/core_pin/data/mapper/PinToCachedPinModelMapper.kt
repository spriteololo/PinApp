package com.test.core_pin.data.mapper

import com.test.core_pin.data.model.CachedPinModel
import com.test.core_pin.domain.model.Pin
import javax.inject.Inject

internal class PinToCachedPinModelMapper @Inject constructor() {

    fun mapFrom(
        pinModel: CachedPinModel,
    ): Pin = with(pinModel) {
        Pin(
            name = first,
            code = second,
        )
    }

    fun mapTo(
        pin: Pin,
    ): CachedPinModel = with(pin) {
        CachedPinModel(
            first = name,
            second = code,
        )
    }

}