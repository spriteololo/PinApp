package com.test.core_base.navigator

import androidx.fragment.app.Fragment

/** Lazy initialize with intent extra [key] */
inline fun <reified T : Any?> Fragment.lazyArg(key: String) = lazy { arguments?.get(key) as T }

/** Lazy initialize with intent extra [key] */
inline fun <reified T : Any?> Fragment.lazyArg(key: String, defaultValue: T) = lazy {
    with(arguments?.get(key) ?: return@lazy defaultValue){
        return@with this as? T ?: defaultValue
    }
}