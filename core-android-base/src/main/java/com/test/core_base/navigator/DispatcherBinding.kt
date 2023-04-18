package com.test.core_base.navigator

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_DESTROY
import androidx.lifecycle.LifecycleEventObserver

internal abstract class DispatcherBinding {

    private val lifecycleObserver = LifecycleEventObserver { _, event ->
        if (event == ON_DESTROY) {
            clear()
        }
    }

    private var navigationChangedDispatcher: OnNavigationChangedDispatcher? = null

    abstract val lifecycle: Lifecycle

    abstract val navigatorProvider: NavigatorProvider

    inline fun bind(crossinline onDispatch: suspend () -> Boolean) {

        navigationChangedDispatcher = object : OnNavigationChangedDispatcher {
            override suspend fun handleOnChanged(): Boolean = onDispatch()
        }

        navigatorProvider.navigationChangedDispatcher = navigationChangedDispatcher
        lifecycle.addObserver(lifecycleObserver)
    }

    private fun clear() {
        navigatorProvider.navigationChangedDispatcher = null
        lifecycle.removeObserver(lifecycleObserver)
    }
}