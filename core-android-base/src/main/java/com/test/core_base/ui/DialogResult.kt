package com.test.core_base.ui

import android.os.Bundle
import androidx.core.os.bundleOf

internal const val TAG = "result"
internal const val REQUEST_CODE = "requestCode"

enum class DialogResult {
    OK,
    CANCEL,
}

val Bundle.dialogResult
    get() = this.getString(TAG)?.let { value -> DialogResult.valueOf(value) }
        ?: throw NullPointerException("Bundle does not contain result")

val Bundle.dialogRequestCode
    get() = this.getString(REQUEST_CODE)

fun DialogResult.toBundle(requestCode: String? = null): Bundle = bundleOf(TAG to this.name).apply {
    if (requestCode != null) {
        putString(REQUEST_CODE, requestCode)
    }
}
