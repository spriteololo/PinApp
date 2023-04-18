package com.test.core_base.ui.adapter.decorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*

class SpaceDecorator(
    private val spaceHeight: Int,
    @Orientation private val orientation: Int = VERTICAL
) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: State
    ) {
        if (orientation == VERTICAL) {
            outRect.bottom = spaceHeight
        } else {
            outRect.right = spaceHeight
        }
    }
}