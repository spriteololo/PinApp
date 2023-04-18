package com.test.core_base.navigator

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.test.core_base.common.RootNavigator

val Fragment.rootNavigator: RootNavigator
    get() {
        val provider = requireActivity() as RootNavigatorProvider
        return provider.rootNavigator
    }

fun Fragment.bindNavigationDispatcher(
    onDispatch: suspend () -> Boolean,
) {
    val provider = parentFragment as? NavigatorProvider ?: requireActivity() as NavigatorProvider

    object : DispatcherBinding() {
        override val lifecycle: Lifecycle
            get() = this@bindNavigationDispatcher.lifecycle
        override val navigatorProvider: NavigatorProvider
            get() = provider
    }.bind(onDispatch)
}