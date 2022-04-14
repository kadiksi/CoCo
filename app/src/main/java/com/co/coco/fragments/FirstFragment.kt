package com.co.coco.fragments

import android.os.Bundle
import android.view.View
import com.co.coco.R
import com.co.coco.dagger.navigator.CoCoNavigation
import com.co.coco.databinding.FragmentFirstBinding
import com.co.coco.model.Computer
import com.co.coco.network.CitiesViewModel
import com.co.core.data.Response
import com.co.core.extensions.flowFragment
import com.co.core.extensions.viewModelsParent
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.redmadrobot.extensions.viewbinding.viewBinding
import timber.log.Timber
import javax.inject.Inject

class FirstFragment : BaseFragment() {

    @Inject
    lateinit var rootLocalRouter: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigation: CoCoNavigation

    @Inject
    lateinit var computer: Computer

    private val cityViewModel: CitiesViewModel by viewModelsParent(
        { viewModelFactory },
        { flowFragment })

    override val layoutId: Int
        get() = R.layout.fragment_first

    private val binding: FragmentFirstBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameTextView.setOnClickListener {
            navigation.openSecondScreen(rootLocalRouter)
//            (activity as? ThemeActionListener)?.toggle()
        }
        binding.nameTextView.text = computer.motherboard.toString()
    }

    override fun initObservers() {
        observe(cityViewModel.citiesLiveData) {
            if (it != null) {
                when (it) {
                    is Response.Success -> {
                        Timber.d(it.toString())
                    }
                    is Response.Error -> Timber.e(it.toString())
                }
            }
        }
        cityViewModel.getCities()
    }
}