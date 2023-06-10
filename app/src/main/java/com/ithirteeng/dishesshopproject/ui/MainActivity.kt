package com.ithirteeng.dishesshopproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.ithirteeng.common.extensions.GLOBAL_ROUTER
import com.ithirteeng.dishesshopproject.R
import com.ithirteeng.features.mainhost.MainHostActivity
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

/*
  Решил не делать singleActivity, так как слышал, что сильная вложенность фрагментов достаточно напряжная для устройств

  Также реализовал это все дело через 2 активити не просто так: ведь если придется добавлять новые экраны (помимо экрана с навбаром),
  то с нынешней реализацией куда проще это сделать, нежели если сразу все в MainActivity
 */
class MainActivity : AppCompatActivity() {

    private val router: Router by inject(named(GLOBAL_ROUTER))
    private val navigationHolder: NavigatorHolder by inject(named(GLOBAL_ROUTER))
    private val navigator = AppNavigator(this, -1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router.newRootScreen(MainHostActivity.provideScreen())
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