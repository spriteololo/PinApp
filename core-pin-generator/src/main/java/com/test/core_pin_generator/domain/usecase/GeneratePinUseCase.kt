package com.test.core_pin_generator.domain.usecase

import com.test.core_pin_generator.domain.PinGenerator
import javax.inject.Inject

interface GeneratePinUseCase {

    fun generatePin(): String
}

internal class GeneratePinUseCaseImpl @Inject constructor(
    private val pinGenerator: PinGenerator
) : GeneratePinUseCase {


    override fun generatePin(): String {
        return pinGenerator.getNewPin()
    }

    companion object {
        private val TAG = GeneratePinUseCaseImpl::class.java.simpleName
    }
}
