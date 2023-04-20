package com.test.feature_pin.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.test.core_base.ui.adapter.decorator.SpaceDecorator
import com.test.core_base.ui.dpToPx
import com.test.core_base.viewbinding.viewBinding
import com.test.feature_pin.R
import com.test.feature_pin.databinding.FragmentPinListBinding
import com.test.feature_pin.di.PinScreenComponent
import com.test.feature_pin.presentation.PinListPresenter
import com.test.feature_pin.presentation.model.PinItem
import com.test.feature_pin.ui.adapter.PinClickListener
import com.test.feature_pin.ui.adapter.PinListAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

internal class PinListFragment : MvpAppCompatFragment(R.layout.fragment_pin_list),
    PinClickListener,
    PinListView {

    private val mainAdapter = PinListAdapter(this@PinListFragment)

    @Inject
    lateinit var presenterProvider: Provider<PinListPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    private val binding: FragmentPinListBinding by viewBinding(FragmentPinListBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        PinScreenComponent.create(this).also { component -> component.inject(this) }
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGeneratePin.setOnClickListener {
            val pinName = binding.etPinName.text.toString()
            if (pinName.isBlank()) {
                Toast.makeText(requireContext(), R.string.pin_name_empty, Toast.LENGTH_SHORT).show()
            } else {
                presenter.generatePin(pinName)
            }
        }

        binding.rvPinList.apply {
            setHasFixedSize(true)
            adapter = mainAdapter
            if (itemDecorationCount == 0) {
                addItemDecoration(SpaceDecorator(12.dpToPx()))
            }
        }
    }

    override fun updatePinList(list: List<PinItem>) {
        mainAdapter.submitList(list)
    }

    override fun onItemClicked(item: PinItem) {
        presenter.deletePin(item.pinName)
    }
}