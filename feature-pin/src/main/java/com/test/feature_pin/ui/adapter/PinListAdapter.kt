package com.test.feature_pin.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.core_base.ui.adapter.BaseAdapter
import com.test.core_base.ui.adapter.BaseClickListener
import com.test.core_base.ui.adapter.BaseDiffUtil
import com.test.feature_pin.R
import com.test.feature_pin.presentation.model.PinItem

internal class PinListAdapter(
    private val clickListener: PinClickListener,
    items: List<PinItem> = emptyList(),
) : BaseAdapter<PinListAdapter.PinItemViewHolder, PinItem>(items.toMutableList()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinItemViewHolder {
        return PinItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pin, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PinItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.run {
            btnDelete.setOnClickListener { clickListener.onItemClicked(item) }
            tvPinName.text = item.pinName
            tvPinCode.text = item.pinCode
        }
    }

    override fun onBindViewHolder(
        holder: PinItemViewHolder,
        position: Int,
        payloads: MutableList<Any>,
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            with(payloads.component1() as Bundle) {
                getString(PinItem.PIN_CODE, null)?.let { pinCode ->
                    holder.tvPinCode.text = pinCode
                }
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    inner class PinItemViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {

        val btnDelete: View = rootView.findViewById(R.id.btn_delete)
        val tvPinName: TextView = rootView.findViewById(R.id.tv_pin_name)
        val tvPinCode: TextView = rootView.findViewById(R.id.tv_pin_code)
    }

    inner class PinDiffUtil(oldList: List<PinItem>, newList: List<PinItem>) :
        BaseDiffUtil<PinItem>(oldList, newList) {

        override fun areItemsTheSame(oldItem: PinItem, newItem: PinItem): Boolean {
            return oldItem.pinName == newItem.pinName
        }

        override fun areContentsTheSame(oldItem: PinItem, newItem: PinItem): Boolean {
            return oldItem.pinName == newItem.pinName && oldItem.pinCode == newItem.pinCode
        }

        override fun fillPayloadBundle(
            oldItem: PinItem,
            newItem: PinItem,
            bundle: Bundle,
        ) {
            if (oldItem.pinCode != newItem.pinCode) {
                bundle.putString(PinItem.PIN_CODE, newItem.pinCode)
            }
        }
    }

    override fun getDiffUtil(
        oldList: List<PinItem>,
        newList: List<PinItem>,
    ): BaseDiffUtil<PinItem> {
        return PinDiffUtil(oldList, newList)
    }
}

internal interface PinClickListener : BaseClickListener<PinItem>
