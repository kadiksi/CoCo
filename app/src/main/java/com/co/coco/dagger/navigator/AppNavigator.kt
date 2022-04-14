package com.co.coco.dagger.navigator

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator

class AppNavigator(
    activity: FragmentActivity,
    fragmentManager: FragmentManager,
    containerId: Int
) : AppNavigator(activity, containerId, fragmentManager) {

    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun applyCommands(commands: Array<out Command>) {
        try {
            if (fragmentManager.isDestroyed)
                return
            super.applyCommands(commands)
        } catch (error: IllegalStateException) {
            handler.postDelayed({
                applyCommands(commands)
            }, 100)
        }
    }
}