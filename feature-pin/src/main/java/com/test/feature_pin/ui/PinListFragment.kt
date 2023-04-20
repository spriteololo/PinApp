package com.test.feature_pin.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.test.core_base.ui.adapter.decorator.SpaceDecorator
import com.test.core_base.ui.dpToPx
import com.test.core_base.viewbinding.viewBinding
import com.test.feature_pin.R
import com.test.feature_pin.databinding.FragmentPinListBinding
import com.test.feature_pin.di.PinScreenComponent
import com.test.feature_pin.presentation.model.PinItem
import com.test.feature_pin.ui.adapter.PinClickListener
import com.test.feature_pin.ui.adapter.PinListAdapter

internal class PinListFragment : Fragment(R.layout.fragment_pin_list), PinClickListener {

    private val mainAdapter = PinListAdapter(this@PinListFragment)

    private val binding: FragmentPinListBinding by viewBinding(FragmentPinListBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PinScreenComponent.create(this).also { component -> component.inject(this) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvPinList.apply {
            setHasFixedSize(true)
            adapter = mainAdapter
            if (itemDecorationCount == 0) {
                addItemDecoration(SpaceDecorator(12.dpToPx()))
            }
        }
    }

    override fun onItemClicked(item: PinItem) {
    }
}