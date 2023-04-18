package com.test.core_base.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

fun DiffUtil.Callback.invalidateInAdapter(
    adapter: RecyclerView.Adapter<*>, detectMoves: Boolean = true
) {
    DiffUtil.calculateDiff(this, detectMoves).dispatchUpdatesTo(adapter)
}