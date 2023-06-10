package com.ithirteeng.features.mainhost

import android.content.Intent
import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.ithirteeng.common.extensions.MAIN_HOST_ROUTER
import com.ithirteeng.features.mainhost.databinding.ActivityMainHostBinding
import com.ithirteeng.features.mainhost.presentation.MainHostViewModel
import com.ithirteeng.features.mainhost.utils.SectionType
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainHostActivity : AppCompatActivity() {

    companion object {
        fun provideScreen() = ActivityScreen { Intent(it, MainHostActivity::class.java) }
    }

    private val binding by lazy {
        ActivityMainHostBinding.inflate(this.layoutInflater)
    }

    private val viewModel: MainHostViewModel by viewModel()

    private val navigationHolder: NavigatorHolder by inject(named(MAIN_HOST_ROUTER))

    private val navigator = AppNavigator(this, R.id.mainHostContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.clearBackstack()
        viewModel.navigateToMainScreen()

        onBackPressedDispatcher.addCallback(this) {
            viewModel.exit()
            selectItem()
        }

        onNavBarItemSelect()
    }

    private var itemSelectedByUser = true

    private fun onNavBarItemSelect() {
        binding.bottomNavBar.setOnItemSelectedListener {
            if (itemSelectedByUser) {
                when (it.itemId) {
                    R.id.main_section -> viewModel.navigateToMainScreen()
                    R.id.cart_section -> viewModel.navigateToCartScreen()
                    else -> {}
                }
            }
            itemSelectedByUser = true
            true
        }
    }

    private fun selectItem() {
        itemSelectedByUser = false
        when (viewModel.getCurrentSectionType()) {
            SectionType.MAIN -> binding.bottomNavBar.selectedItemId = R.id.main_section
            SectionType.CART -> binding.bottomNavBar.selectedItemId = R.id.cart_section
            SectionType.SEARCH -> binding.bottomNavBar.selectedItemId = R.id.search_section
            SectionType.ACCOUNT -> binding.bottomNavBar.selectedItemId = R.id.account_section
            else -> return
        }
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