package com.test.core_pin_generator.domain

interface PinGenerator {

    fun getNewPin(
        numberOfDigits: Int = NUMBER_OF_DIGITS,
        maxNumberOfOccasions: Int = MAX_NUMBER_OF_OCCASIONS,
    ): String

    companion object {
        private const val NUMBER_OF_DIGITS = 6
        private const val MAX_NUMBER_OF_OCCASIONS = 3
    }
}