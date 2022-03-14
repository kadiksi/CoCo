package com.co.coco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.co.coco.R
import com.co.coco.dagger.navigator.MarketAppNavigator
import com.co.coco.dagger.navigator.MarketNavigation
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ContainerFragment : BaseFragment() {

    @Inject
    lateinit var rootLocalRouter: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigation: MarketNavigation

    override val layoutId = R.layout.fragment_container

    private var navigator: Navigator? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigator = MarketAppNavigator(requireActivity(), childFragmentManager, R.id.container)
        navigation.openFirstScreen(rootLocalRouter)
    }

    override fun onResume() {
        super.onResume()
        if (navigator != null) {
            navigatorHolder.setNavigator(navigator!!)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed(): Boolean {
        when {
            childFragmentManager.backStackEntryCount > 1 -> {
                return super.onBackPressed()
            }
        }
        rootLocalRouter.exit()
        return true
    }
}