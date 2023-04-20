package com.test.core_pin.domain.usecase

import com.test.core_pin.domain.PinRepository
import com.test.core_pin.domain.model.Pin
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface ObservePinListUseCase {

    fun pinList(): Observable<List<Pin>>
}

internal class ObservePinListUseCaseImpl @Inject constructor(
    private val pinRepository: PinRepository,
) : ObservePinListUseCase {

    override fun pinList(): Observable<List<Pin>> {
        return pinRepository.observePinList()
    }

    companion object {
        private val TAG = ObservePinListUseCaseImpl::class.java.simpleName
    }
}
