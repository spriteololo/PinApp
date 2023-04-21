package com.test.feature_pin.ui

import com.test.feature_pin.presentation.model.PinItem
import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface PinListView: MvpView {

    @OneExecution
    fun updatePinList(list: List<PinItem>)

    @OneExecution
    fun itemExists(pinName: String)

    @OneExecution
    fun showError()
}