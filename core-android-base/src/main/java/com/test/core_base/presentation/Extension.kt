package com.test.core_base.presentation

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.test.core_base.common.BaseApi

val Application.baseApi: BaseApi
    get() = this as BaseApi

val Activity.baseApi: BaseApi
    get() = this.application.baseApi

val Fragment.baseApplication: BaseApi
    get() = this.requireActivity().baseApi