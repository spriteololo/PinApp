package com.test.core_base.navigator

import androidx.fragment.app.Fragment
import com.test.core_base.common.RootNavigator

val Fragment.rootNavigator: RootNavigator
    get() {
        val provider = requireActivity() as RootNavigatorProvider
        return provider.rootNavigator
    }