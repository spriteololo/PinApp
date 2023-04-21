package com.test.feature_pin.domain.usecase

import com.test.core_pin.domain.model.Pin
import com.test.core_pin.domain.usecase.SavePinUseCase
import com.test.core_pin_generator.domain.usecase.GeneratePinUseCase
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface GenerateAndSaveNewPinUseCase {

    fun generateAndSavePin(pinName: String): Completable
}

internal class GenerateAndSaveNewPinUseCaseImpl @Inject constructor(
    private val generatePinUseCase: GeneratePinUseCase,
    private val savePinUseCase: SavePinUseCase,
) : GenerateAndSaveNewPinUseCase {
    override fun generateAndSavePin(pinName: String): Completable =
        Single.fromCallable { generatePinUseCase.generatePin() }
            .flatMapCompletable { generatedPinCode ->
                val pin = Pin(
                    pinName,
                    generatedPinCode,
                )
                savePinUseCase.savePin(pin)
            }
}