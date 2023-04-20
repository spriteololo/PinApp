package com.test.feature_pin.domain.usecase

import javax.inject.Inject

interface GenerateNewPinUseCase {

    suspend fun generatePin(pinName: String): Boolean
}

internal class GenerateNewPinUseCaseImpl @Inject constructor(
    private val generatePinUseCase: GeneratePinUseCase,
    private val savePinUseCase: SavePinUseCase,
) : GenerateNewPinUseCase {
    override suspend fun generatePin(pinName: String): Boolean {
        val generatedPinCode = generatePinUseCase.generatePin()

        return savePinUseCase.savePin(pinName, generatedPinCode)
    }
}