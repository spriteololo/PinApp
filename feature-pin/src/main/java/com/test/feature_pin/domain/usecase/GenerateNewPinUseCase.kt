package com.test.feature_pin.domain.usecase

import com.test.core_pin.domain.model.Pin
import com.test.core_pin.domain.usecase.SavePinUseCase
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject
import kotlin.random.Random

interface GenerateNewPinUseCase {

    fun generatePin(pinName: String): Completable
}

internal class GenerateNewPinUseCaseImpl @Inject constructor(
//    private val generatePinUseCase: GeneratePinUseCase,
    private val savePinUseCase: SavePinUseCase,
) : GenerateNewPinUseCase {
    override fun generatePin(pinName: String): Completable {
//        val generatedPinCode = generatePinUseCase.generatePin()

        val pin = Pin(
            pinName,
            Random.nextInt(),
        ) //TODO
        return savePinUseCase.savePin(pin)
    }
}