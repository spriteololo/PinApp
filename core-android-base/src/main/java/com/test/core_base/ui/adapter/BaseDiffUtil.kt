package com.test.core_base.ui.adapter

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtil<T>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return areItemsTheSame(oldItem, newItem)
    }

    abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return areContentsTheSame(oldItem, newItem)
    }

    abstract fun areContentsTheSame(oldItem: T, newItem: T): Boolean


    /**
     * For payloads
     * */
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        with(bundleOf()) {
            fillPayloadBundle(oldItem, newItem, this)

            return if (isEmpty) null else this
        }
    }

    open fun fillPayloadBundle(oldItem: T, newItem: T, bundle: Bundle) {}
}