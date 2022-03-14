package com.co.coco

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.co.coco.databinding.ActivityMainBinding
import com.co.coco.fragments.BaseFragment
import com.co.coco.fragments.ContainerFragment
import com.co.coco.model.Computer
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var computer: Computer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.titleTextView.text = computer.motherboard.toString()

        addContainerFragment(ContainerFragment())
    }

    private fun addContainerFragment(
        fragment: Fragment,
    ) {
        val tr = supportFragmentManager.beginTransaction()
        tr.add(R.id.containerFrameLayout, fragment)
        tr.commit()
    }

    override fun onBackPressed() {
        handleOnBackPressed()
    }

    private fun handleOnBackPressed(@IdRes id: Int = R.id.containerFrameLayout) {
        val fragment = supportFragmentManager.findFragmentById(id)
        if (fragment == null) {
            finish()
        } else if (fragment is BaseFragment) {
            if (fragment.onBackPressed()) {
                handleBackStack()
            } else {
                return
            }
        } else {
            handleBackStack()
        }
    }

    private fun handleBackStack() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}