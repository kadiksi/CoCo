package com.co.coco.dagger.navigator

import com.co.coco.fragments.FirstFragment
import com.co.coco.fragments.SecondFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun firstScreen() = FragmentScreen { FirstFragment() }

    fun secondScreen() = FragmentScreen { SecondFragment() }
}