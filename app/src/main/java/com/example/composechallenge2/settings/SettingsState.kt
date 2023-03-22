package com.example.composechallenge2.settings

import androidx.annotation.StringRes
import com.example.composechallenge2.R

data class SettingsState(
    val notificationEnabled: Boolean = false,
    val showHints: Boolean = true,
    val marketingOption: MarketingOptions = MarketingOptions.NOT_ALLOWED,
    val theme: Theme = Theme.FOLLOW_SYSTEM
)

enum class MarketingOptions(val id: Int) {
    ALLOWED(0), NOT_ALLOWED(1)
}

enum class Theme(@StringRes val title: Int) {
    LIGHT(R.string.light),
    DARK(R.string.dark),
    FOLLOW_SYSTEM(R.string.follow_system)
}


