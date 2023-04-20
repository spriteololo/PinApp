package com.test.feature_pin.ui

import com.test.feature_pin.presentation.model.PinItem
import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
interface PinListView: MvpView {

    @OneExecution
    fun updatePinList(list: List<PinItem>)
}