package com.test.pinapp.navigator

import com.test.core_base.common.RootNavigator
import com.test.core_base.ui.OkCancelDialog
import com.test.feature_pin.navigator.PinListStarter
import com.test.pinapp.ui.MainActivity
import javax.inject.Inject

internal class RootNavigatorImpl @Inject constructor(
    private val activity: MainActivity,
    private val pinListStarter: PinListStarter,
) : RootNavigator {

    override fun openPinList() {
        pinListStarter.startPinList(
            activity.supportFragmentManager,
            activity.containerView.id
        )
    }

    override fun showDialog(
        tag: String,
        title: String,
        message: String,
        okButton: String,
        cancelButton: String,
        requestCode: String?,
    ) {
        OkCancelDialog.show(
            activity,
            tag,
            title = title,
            message = message,
            okButton = okButton,
            requestCode = requestCode,
        )
    }

    override fun showDialog(
        tag: String,
        title: Int?,
        message: Int?,
        okButton: Int,
        cancelButton: Int?,
        requestCode: String?,
    ) {

        OkCancelDialog.show(
            activity,
            tag,
            title = title,
            message = message,
            okButton = okButton,
            cancelButton = cancelButton,
            requestCode = requestCode,
        )
    }
}