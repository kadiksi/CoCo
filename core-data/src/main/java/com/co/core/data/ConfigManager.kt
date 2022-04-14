package com.co.core.data

interface ConfigManager {
    val appInfo: AppInfo
    var customServerEnabled: Boolean
    var customServer: String?
}