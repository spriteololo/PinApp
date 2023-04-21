package com.test.core_pin.data

import com.test.core_base.streams.DispatcherProvider
import com.test.core_pin.data.mapper.PinToCachedPinModelMapper
import com.test.core_pin.domain.PinRepository
import com.test.core_pin.domain.model.Pin
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

internal class PinRepositoryImpl @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val mapper: PinToCachedPinModelMapper,
    private val pinManager: PinManager,
) : PinRepository {

    override fun observePinList(): Observable<List<Pin>> =
        pinManager.observePinList()
            .map { pins -> pins.map(mapper::mapFrom) }
            .subscribeOn(dispatcherProvider.io)

    override fun savePin(pin: Pin): Completable =
        pinManager.savePin(mapper.mapTo(pin))
            .subscribeOn(dispatcherProvider.io)

    override fun deletePin(name: String): Completable =
        pinManager.deletePin(name)
            .subscribeOn(dispatcherProvider.io)

    override fun getPin(name: String): Maybe<Pin> =
        pinManager.getPin(name)
            .map(mapper::mapFrom)
            .subscribeOn(dispatcherProvider.io)

    override fun deleteAll(): Completable =
        pinManager.deleteAll()
            .subscribeOn(dispatcherProvider.io)
}