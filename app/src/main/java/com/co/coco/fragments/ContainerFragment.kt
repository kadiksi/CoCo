package com.co.coco.fragments

import android.os.Bundle
import android.view.View
import com.co.coco.R
import com.co.coco.dagger.navigator.AppNavigator
import com.co.coco.dagger.navigator.CoCoNavigation
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ContainerFragment : BaseFragment() {

    @Inject
    lateinit var rootLocalRouter: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigation: CoCoNavigation

    override val layoutId = R.layout.fragment_container

    private var navigator: Navigator? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigator = AppNavigator(requireActivity(), childFragmentManager, R.id.container)
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