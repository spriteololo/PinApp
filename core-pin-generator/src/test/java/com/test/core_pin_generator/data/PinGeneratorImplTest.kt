package com.test.core_pin_generator.data

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.random.Random

internal class PinGeneratorImplTest {

    private val sut = PinGeneratorImpl()

    @Test
    fun `when sending negative value as number of digits generator should throw an exception`() {
        assertThrows<IllegalArgumentException>("NumberOfDigits must be non-negative value") {
            sut.getNewPin(numberOfDigits = -1)
        }
    }

    @Test
    fun `when sending 0 as number of digits generator should return empty string`() {
        val actual = sut.getNewPin(numberOfDigits = 0)
        assertThat(actual).isEmpty()
    }

    @Test
    fun `digits generator should return the same length result string as number of digits arg`() {
        for (i in 1..20) {
            val actual = sut.getNewPin(numberOfDigits = i)
            assertThat(actual.length).isEqualTo(i)
        }
    }

    @Test
    fun `when max number of occasion multiply range of numbers is less than expected length of pin code generator should throw exception`() {
        assertThrows<IllegalArgumentException>("Couldn't generate pin with such parameters") {
            sut.getNewPin(numberOfDigits = 31, maxNumberOfOccasions = 3)
        }
        assertDoesNotThrow {
            sut.getNewPin(numberOfDigits = 30, maxNumberOfOccasions = 3)
        }
        assertThrows<IllegalArgumentException>("Couldn't generate pin with such parameters") {
            sut.getNewPin(numberOfDigits = 21, maxNumberOfOccasions = 2)
        }
        assertDoesNotThrow {
            sut.getNewPin(numberOfDigits = 20, maxNumberOfOccasions = 2)
        }
    }

    @Test
    fun `digits generator correct workflow`() {
        val randomMaxNumberOfOccasions = Random.nextInt(2, 5)
        for (i in 1..10000) {
            val actual = sut.getNewPin(maxNumberOfOccasions = randomMaxNumberOfOccasions)
            val occasions = actual.groupingBy { it }.eachCount().values

            assertThat(occasions.count { occasion -> occasion > randomMaxNumberOfOccasions })
                .isZero
        }
    }
}