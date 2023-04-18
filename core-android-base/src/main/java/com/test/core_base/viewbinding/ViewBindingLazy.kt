package com.test.core_base.viewbinding

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_DESTROY
import androidx.lifecycle.Lifecycle.State.DESTROYED
import androidx.lifecycle.LifecycleEventObserver
import androidx.viewbinding.ViewBinding

abstract class ViewBindingLazy<Binding : ViewBinding> : Lazy<Binding> {

    private var cachedViewBinding: Binding? = null

    private val mainHandler: Handler = Handler(Looper.getMainLooper())

    private val lifecycleObserver = LifecycleEventObserver { _, event ->
        if (event == ON_DESTROY) {
            clear()
        }
    }

    abstract val lifecycle: Lifecycle

    abstract fun bind(): Binding

    override val value: Binding
        get() = this.cachedViewBinding ?: bind().also(::init)

    override fun isInitialized() = this.cachedViewBinding != null

    private fun init(viewBinding: Binding) {
        if (lifecycle.currentState == DESTROYED) {
            return
        }

        lifecycle.addObserver(lifecycleObserver)
        this.cachedViewBinding = viewBinding
    }

    private fun clear() {
        lifecycle.removeObserver(lifecycleObserver)
        clearBindingAfterOnDestroyView()
    }

    private fun clearBindingAfterOnDestroyView() {
        mainHandler.post { cachedViewBinding = null }
    }
}
