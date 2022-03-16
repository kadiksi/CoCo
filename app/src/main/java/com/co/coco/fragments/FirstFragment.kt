package com.co.coco.fragments

import android.os.Bundle
import android.view.View
import com.co.coco.R
import com.co.coco.dagger.navigator.MarketNavigation
import com.co.coco.databinding.FragmentFirstBinding
import com.co.coco.helpers.ThemeActionListener
import com.co.coco.model.Computer
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject

class FirstFragment : BaseFragment() {

    @Inject
    lateinit var rootLocalRouter: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigation: MarketNavigation

    @Inject
    lateinit var computer: Computer

    override val layoutId: Int
        get() = R.layout.fragment_first

    private val binding: FragmentFirstBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameTextView.setOnClickListener {
//            navigation.openSecondScreen(rootLocalRouter)
            (activity as? ThemeActionListener)?.toggle()
        }
        binding.nameTextView.text = computer.motherboard.toString()
    }
}