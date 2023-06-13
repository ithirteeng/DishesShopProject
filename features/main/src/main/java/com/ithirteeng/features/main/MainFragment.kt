package com.ithirteeng.features.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ithirteeng.common.extensions.LOCAL_ROUTER
import com.ithirteeng.features.main.databinding.FragmentMainBinding
import com.ithirteeng.features.main.presentation.MainViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainFragment : Fragment() {

    companion object {
        fun provideScreen() = FragmentScreen { MainFragment() }
    }

    private lateinit var binding: FragmentMainBinding

    private val navigationHolder: NavigatorHolder by inject(named(LOCAL_ROUTER))

    private val navigator by lazy {
        AppNavigator(requireActivity(), R.id.mainContainer, childFragmentManager)
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.navigateToKitchensScreen()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val layout = inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.bind(layout)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }
}