package com.test.core_base.viewbinding

import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.viewbinding.ViewBinding

inline fun <reified BindingT : ViewBinding> ComponentActivity.viewBinding(
    crossinline bind: (View) -> BindingT,
) = object : ViewBindingLazy<BindingT>() {

    private val view: View
        get() = findViewById<ViewGroup>(android.R.id.content).getChildAt(0)

    override val lifecycle: Lifecycle
        get() = this@viewBinding.lifecycle

    override fun bind(): BindingT = bind(view)
}

inline fun <reified BindingT : ViewBinding> Fragment.viewBinding(
    crossinline bind: (View) -> BindingT,
) = object : ViewBindingLazy<BindingT>() {

    override val lifecycle: Lifecycle
        get() = viewLifecycleOwner.lifecycle

    override fun bind(): BindingT = bind(requireView())
}

inline fun <reified BindingT : ViewBinding> View.viewBinding(
    crossinline bind: (View) -> BindingT,
) = object : ViewBindingLazy<BindingT>() {

    override val lifecycle: Lifecycle
        get() = findViewTreeLifecycleOwner()?.lifecycle ?: throw IllegalStateException("There is no lifecycle :(")

    override fun bind(): BindingT = bind(this@viewBinding)
}
