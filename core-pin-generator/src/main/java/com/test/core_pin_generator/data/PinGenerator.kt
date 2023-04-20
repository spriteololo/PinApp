package com.test.core_pin_generator.data

import com.test.core_pin_generator.domain.PinGenerator
import javax.inject.Inject
import kotlin.random.Random

internal class PinGeneratorImpl @Inject constructor() : PinGenerator {

    override fun getNewPin(): String {
        val pinArr = arrayOfNulls<Int>(NUMBER_OF_DIGITS)
        for (i in 0 until NUMBER_OF_DIGITS) {
            var tempNum: Int
            do {
                tempNum = Random.nextInt(0, 10)
            } while (i >= MAX_NUMBER_OF_OCCASIONS &&
                pinArr.count { it == tempNum } >= MAX_NUMBER_OF_OCCASIONS
            )
            pinArr[i] = tempNum
        }
        return pinArr.joinToString(separator = "")
    }

    companion object {
        private const val NUMBER_OF_DIGITS = 6
        private const val MAX_NUMBER_OF_OCCASIONS = 3
    }
}