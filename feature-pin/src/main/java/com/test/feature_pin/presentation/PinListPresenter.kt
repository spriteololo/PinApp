package com.test.feature_pin.presentation

import com.test.core_base.streams.DispatcherProvider
import com.test.core_base.streams.rx.plusAssign
import com.test.core_pin.domain.model.Pin
import com.test.core_pin.domain.usecase.DeletePinUseCase
import com.test.core_pin.domain.usecase.ObservePinListUseCase
import com.test.feature_pin.domain.usecase.GenerateNewPinUseCase
import com.test.feature_pin.presentation.mapper.PinToPinItemMapper
import com.test.feature_pin.ui.PinListView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
internal class PinListPresenter @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val generateNewPinUseCase: GenerateNewPinUseCase,
    private val deletePinUseCase: DeletePinUseCase,
    private val observePinListUseCase: ObservePinListUseCase,
    private val mapper: PinToPinItemMapper,
) : MvpPresenter<PinListView>() {

    var disposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: PinListView?) {
        super.attachView(view)
        disposable += observePinListUseCase.pinList()
            .map { list ->
                list.sortedBy(Pin::name)
                    .map(mapper::mapFrom)
            }
            .observeOn(dispatcherProvider.main)
            .subscribe { list ->
                viewState.updatePinList(list)
            }
    }

    override fun detachView(view: PinListView?) {
        super.detachView(view)
        disposable.clear()
    }

    fun deletePin(pinName: String) {
        disposable += deletePinUseCase.deletePin(pinName)
            .subscribe()
    }

    fun generatePin(pinName: String) {
        disposable += generateNewPinUseCase.generatePin(pinName)
            .subscribe()
    }
}