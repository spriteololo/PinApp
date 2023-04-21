package com.test.core_pin.domain.usecase

import com.test.core_pin.domain.PinRepository
import com.test.core_pin.domain.model.Pin
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

interface SavePinUseCase {

    fun savePin(pin: Pin): Completable
}

internal class SavePinUseCaseImpl @Inject constructor(
    private val pinRepository: PinRepository,
) : SavePinUseCase {

    override fun savePin(pin: Pin): Completable {
        return pinRepository.savePin(pin)
    }

    companion object {
        private val TAG = SavePinUseCaseImpl::class.java.simpleName
    }
}
