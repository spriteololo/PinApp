package com.test.feature_pin.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Parcelize
data class PinItem(
    val pinName: String,
    val pinCode: String,
): Parcelable {

    @Keep
    companion object {
        const val PIN_NAME = "pinName"
        const val PIN_CODE = "pinCode"
    }
}