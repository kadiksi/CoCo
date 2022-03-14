package com.co.coco.fragments

import android.os.Bundle
import android.view.View
import com.co.coco.R
import com.co.coco.databinding.FragmentFirstBinding
import com.redmadrobot.extensions.viewbinding.viewBinding

class SecondFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_first

    private val binding: FragmentFirstBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameTextView.text = "123"
    }
}