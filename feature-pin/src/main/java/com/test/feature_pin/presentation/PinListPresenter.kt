package com.test.feature_pin.presentation

import com.test.core_base.streams.DispatcherProvider
import com.test.core_base.streams.rx.plusAssign
import com.test.core_pin.domain.model.Pin
import com.test.core_pin.domain.usecase.DeletePinUseCase
import com.test.core_pin.domain.usecase.GetPinUseCase
import com.test.core_pin.domain.usecase.ObservePinListUseCase
import com.test.feature_pin.domain.usecase.GenerateAndSaveNewPinUseCase
import com.test.feature_pin.presentation.mapper.PinToPinItemMapper
import com.test.feature_pin.ui.PinListView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
internal class PinListPresenter @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val generateAndSaveNewPinUseCase: GenerateAndSaveNewPinUseCase,
    private val deletePinUseCase: DeletePinUseCase,
    private val getPinUseCase: GetPinUseCase,
    private val observePinListUseCase: ObservePinListUseCase,
    private val mapper: PinToPinItemMapper,
) : MvpPresenter<PinListView>() {

    private var disposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: PinListView?) {
        super.attachView(view)
        disposable += observePinListUseCase.pinList()
            .map { list ->
                list.sortedWith(compareBy { pin -> pin.name.lowercase() })
                    .map(mapper::mapFrom)
            }
            .observeOn(dispatcherProvider.main)
            .subscribe({ list ->
                viewState.updatePinList(list)
            }) { throwable ->
                throwable.printStackTrace()
                viewState.showError()
            }
    }

    override fun detachView(view: PinListView?) {
        super.detachView(view)
        disposable.clear()
    }

    fun deletePin(pinName: String) {
        disposable += deletePinUseCase.deletePin(pinName)
            .observeOn(dispatcherProvider.main)
            .subscribe({}) { throwable ->
                throwable.printStackTrace()
                viewState.showError()
            }
    }

    fun generateAndSavePin(pinName: String) {
        disposable += getPinUseCase.getPin(pinName)
            .toSingle()
            .subscribeOn(dispatcherProvider.io)
            .observeOn(dispatcherProvider.main)
            .doOnSuccess { pin ->
                viewState.itemExists(pin.name)
            }
            .observeOn(dispatcherProvider.io)
            .ignoreElement()
            .onErrorResumeNext {
                if (it is NoSuchElementException) {
                    generateAndSaveNewPinUseCase.generateAndSavePin(pinName)
                } else {
                    throw it
                }
            }
            .observeOn(dispatcherProvider.main)
            .subscribe({}) { throwable ->
                throwable.printStackTrace()
                viewState.showError()
            }
    }
}