package com.test.core_base.streams.rx

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

infix operator fun CompositeDisposable.plusAssign(other: Disposable) {
    add(other)
}