package com.test.core_base.common

interface RootNavigator {

    fun openPinList()

    fun showDialog(
        tag: String,
        title: String,
        message: String,
        okButton: String,
        cancelButton: String,
        requestCode: String? = null,
    )

    fun showDialog(
        tag: String,
        title: Int? = null,
        message: Int? = null,
        okButton: Int,
        cancelButton: Int? = null,
        requestCode: String? = null,
    )
}