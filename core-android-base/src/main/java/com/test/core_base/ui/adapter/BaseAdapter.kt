package com.test.core_base.ui.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : RecyclerView.ViewHolder, W>(
    protected val itemList: MutableList<W> = mutableListOf()
) : RecyclerView.Adapter<T>(), Submittable<W> {

    abstract fun getDiffUtil(oldList: List<W>, newList: List<W>): BaseDiffUtil<W>

    override fun submitList(newList: List<W>) {
        val oldList = itemList.toMutableList()
        itemList.clear()
        itemList.addAll(newList)

        getDiffUtil(oldList, newList).invalidateInAdapter(this)
    }
}

interface Submittable<in W> {
    fun submitList(newList: List<W>)
}

interface BaseClickListener<in T>{
    fun onItemClicked(item: T)
}
