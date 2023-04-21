package com.test.core_pin_generator.data

import com.test.core_pin_generator.domain.PinGenerator
import javax.inject.Inject
import kotlin.random.Random

internal class PinGeneratorImpl @Inject constructor() : PinGenerator {

    override fun getNewPin(numberOfDigits: Int, maxNumberOfOccasions: Int): String {
        if (numberOfDigits < 0) {
            throw IllegalArgumentException("NumberOfDigits must be non-negative value")
        }
        if ((NUMBER_RANGE_UNTIL - NUMBER_RANGE_FROM) * maxNumberOfOccasions < numberOfDigits) {
            throw IllegalArgumentException("Couldn't generate pin with such parameters")
        }
        val pinArr = arrayOfNulls<Int>(numberOfDigits)
        for (i in 0 until numberOfDigits) {
            var tempNum: Int
            do {
                tempNum = Random.nextInt(NUMBER_RANGE_FROM, NUMBER_RANGE_UNTIL)
            } while (i >= maxNumberOfOccasions &&
                pinArr.count { it == tempNum } >= maxNumberOfOccasions
            )
            pinArr[i] = tempNum
        }
        return pinArr.joinToString(separator = "")
    }

    companion object {
        private const val NUMBER_RANGE_FROM = 0
        private const val NUMBER_RANGE_UNTIL = 10
    }
}