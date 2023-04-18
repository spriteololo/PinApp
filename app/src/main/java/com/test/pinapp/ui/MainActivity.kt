package com.test.pinapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.test.core_base.common.RootNavigator
import com.test.core_base.navigator.RootNavigatorProvider
import com.test.pinapp.PinApplication
import com.test.pinapp.R
import com.test.pinapp.databinding.ActivityMainBinding
import com.test.pinapp.di.MainActivityComponent

internal class MainActivity : AppCompatActivity(), RootNavigatorProvider {

    private lateinit var binding: ActivityMainBinding

    private lateinit var activityComponent: MainActivityComponent

    override val rootNavigator: RootNavigator get() = activityComponent.navigator()

    val containerView: FragmentContainerView get() = binding.container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = MainActivityComponent.create(application as PinApplication, this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }
}