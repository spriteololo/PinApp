package com.test.feature_pin.presentation.mapper

import com.test.feature_pin.presentation.model.PinItem
import javax.inject.Inject

internal class PinToPinItemMapper @Inject constructor() {

    fun mapFrom(pin: Pin): PinItem =
        PinItem(
            pinName = pin.name,
            pinCode = pin.code,
        )
}