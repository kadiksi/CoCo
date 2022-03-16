package com.co.coco

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.co.coco.databinding.ActivityMainBinding
import com.co.coco.fragments.BaseFragment
import com.co.coco.fragments.ContainerFragment
import com.co.coco.helpers.ThemeActionListener
import com.co.coco.helpers.ThemeHandler
import com.co.coco.model.Computer
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity(), ThemeActionListener {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var computer: Computer

    @Inject
    @Named("session")
    lateinit var sharedPreferences: SharedPreferences

    private lateinit var themeHandler: ThemeHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        themeHandler = ThemeHandler(this, sharedPreferences)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSystemUiColor()
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

    override fun toggle() {
        themeHandler.toggle()
    }

    override val isDarkTheme: Boolean
        get() = themeHandler.isDarkTheme

    private fun setSystemUiColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags: Int = window.decorView.systemUiVisibility
            flags = if (isDarkTheme) {
                flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            } else {
                flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            window.apply {
                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                statusBarColor = Color.TRANSPARENT
                decorView.systemUiVisibility = flags
            }
        }
    }
}