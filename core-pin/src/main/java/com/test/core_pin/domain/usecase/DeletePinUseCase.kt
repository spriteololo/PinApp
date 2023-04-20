package com.test.core_pin.domain.usecase

import com.test.core_pin.domain.PinRepository
import com.test.core_pin.domain.model.Pin
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

interface DeletePinUseCase {

    fun deletePin(name: String): Completable
}

internal class DeletePinUseCaseImpl @Inject constructor(
    private val pinRepository: PinRepository,
) : DeletePinUseCase {

    override fun deletePin(name: String): Completable {
        return pinRepository.deletePin(name)
    }

    companion object {
        private val TAG = DeletePinUseCaseImpl::class.java.simpleName
    }
}
