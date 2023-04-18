package com.test.core_base.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class PagerAdapter<T : RecyclerView.ViewHolder, W>(
    private val tabsCount: Int,
) : RecyclerView.Adapter<PagerAdapter.ViewHolder>() {

    private val viewHolderPool = RecyclerView.RecycledViewPool()

    /**
     * Adapter of every page
     * */
    private val _innerAdapterList by lazy {
        arrayListOf<BaseAdapter<T, W>>().apply {
            (0..tabsCount).forEach { position ->
                add(createInnerAdapter(position))
            }
        }
    }

    protected val innerAdapterList: List<Submittable<W>>
        get() = _innerAdapterList

    abstract fun createInnerAdapter(tabPosition: Int): BaseAdapter<T, W>

    /**
     * Root layout of every page (to add progress view etc)
     */
    abstract val pageLayoutRes: Int
        @LayoutRes get

    abstract fun createViewHolder(view: View): ViewHolder

    open fun setInnerData(position: Int, data: List<W>) {
        innerAdapterList.getOrNull(position)?.submitList(data)
    }

    override fun getItemCount(): Int = tabsCount

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(pageLayoutRes, parent, false)
        return createViewHolder(root)
    }

    @CallSuper
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recyclerView.run {
            setHasFixedSize(true)
            adapter = _innerAdapterList[position]
            setRecycledViewPool(viewHolderPool)
        }
    }

    abstract class ViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {

        abstract val recyclerView: RecyclerView
    }
}