package com.co.coco.dagger.navigator

import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MarketNavigation @Inject constructor(
    private val router: Router
) {

    fun openFirstScreen(router: Router?) {
        router?.navigateTo(Screens.firstScreen())
    }

    fun openSecondScreen(router: Router?) {
        router?.navigateTo(Screens.secondScreen())
    }
}