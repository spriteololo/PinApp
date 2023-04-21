package com.test.feature_pin.presentation.model

import androidx.annotation.Keep

data class PinItem(
    val pinName: String,
    val pinCode: String,
) {

    @Keep
    companion object {
        const val PIN_CODE = "pinCode"
    }
}