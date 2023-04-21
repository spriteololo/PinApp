package com.test.feature_pin.navigator

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.test.feature_pin.ui.PinListFragment
import javax.inject.Inject

interface PinListStarter {

    fun startPinList(
        fragmentManager: FragmentManager,
        containerId: Int,
    )
}

internal class PinListStarterImpl @Inject constructor() : PinListStarter {

    override fun startPinList(
        fragmentManager: FragmentManager,
        containerId: Int,
    ) {
        fragmentManager.commit {
            replace(containerId, PinListFragment())
        }
    }
}