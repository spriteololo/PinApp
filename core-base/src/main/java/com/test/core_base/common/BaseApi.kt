package com.test.core_base.common

import io.reactivex.rxjava3.disposables.CompositeDisposable

interface BaseApi {

    fun compositeDisposable(): CompositeDisposable
}