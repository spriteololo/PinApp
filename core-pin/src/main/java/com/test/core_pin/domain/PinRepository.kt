package com.test.core_pin.domain

import com.test.core_pin.domain.model.Pin
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

interface PinRepository {

    fun observePinList(): Observable<List<Pin>>

    fun savePin(pin: Pin): Completable

    fun deletePin(name: String): Completable

    fun getPin(name: String): Maybe<Pin>

    fun deleteAll(): Completable
}