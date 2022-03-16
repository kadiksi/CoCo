package com.co.coco.helpers

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import com.co.coco.R

private const val PREF_KEY = "theme"

enum class Theme(val storageKey: String) {
    LIGHT("light"),
    DARK("dark")
}

fun themeFromStorageKey(storageKey: String): Theme {
    return Theme.values().first { it.storageKey == storageKey }
}

class ThemeHandler(
    private val activity: AppCompatActivity,
    private val sharedPreferences: SharedPreferences
) {
    private var theme = themeFromStorageKey(
        sharedPreferences.getString(PREF_KEY, Theme.LIGHT.storageKey)!!
    )

    val isDarkTheme: Boolean
        get() = theme == Theme.DARK

    val currentTheme: Theme
        get() = theme

    init {
        updateForTheme(theme)
    }

    fun toggle() {
        theme = if (theme == Theme.DARK) {
            Theme.LIGHT
        } else {
            Theme.DARK
        }
        updateForTheme(theme)
        sharedPreferences.edit {
            putString(PREF_KEY, theme.storageKey)
        }
        activity.window.setWindowAnimations(R.style.WindowAnimationFadeInOut);
        activity.recreate()
    }

    private fun updateForTheme(theme: Theme) = when (theme) {
        Theme.DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        Theme.LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}