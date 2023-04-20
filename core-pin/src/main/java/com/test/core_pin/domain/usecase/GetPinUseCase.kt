package com.test.core_pin.domain.usecase

import com.test.core_pin.domain.PinRepository
import com.test.core_pin.domain.model.Pin
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

interface GetPinUseCase {

    fun getPin(pinName: String): Maybe<Pin>
}

internal class GetPinUseCaseImpl @Inject constructor(
    private val pinRepository: PinRepository,
) : GetPinUseCase {

    override fun getPin(pinName: String): Maybe<Pin> {
        return pinRepository.getPin(pinName)
    }

    companion object {
        private val TAG = GetPinUseCaseImpl::class.java.simpleName
    }
}
