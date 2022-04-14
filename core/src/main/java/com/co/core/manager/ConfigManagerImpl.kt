package com.co.core.manager

import android.content.SharedPreferences
import androidx.core.content.edit
import com.co.core.data.AppInfo
import com.co.core.data.ConfigManager
import javax.inject.Inject

class ConfigManagerImpl @Inject constructor(
    private val _apiInfo: AppInfo,
    private val sharedPreferences: SharedPreferences
) : ConfigManager {

    override val appInfo: AppInfo
        get() = _apiInfo

    override var customServerEnabled: Boolean
        get() = sharedPreferences.getBoolean("config_custom_server_enabled", false)
        set(value) {
            sharedPreferences.edit(commit = true) {
                putBoolean("config_custom_server_enabled", value)
            }
        }

    override var customServer: String?
        get() = sharedPreferences.getString("config_custom_server", null)
        set(value) {
            sharedPreferences.edit(commit = true) {
                putString("config_custom_server", value)
            }
        }
}