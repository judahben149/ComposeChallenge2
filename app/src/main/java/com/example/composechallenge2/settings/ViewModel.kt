package com.example.composechallenge2.settings
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow


class SettingsViewModel: ViewModel() {

    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotifications() {
        uiState.value.copy(notificationEnabled = !uiState.value.notificationEnabled)
    }

    fun toggleHintOptions() {
        uiState.value.copy(showHints = !uiState.value.showHints)
    }

    fun changeMarketingOptions(option: MarketingOptions) {
        uiState.value.copy(marketingOption = option)
    }

    fun changeTheme(themeOption: Theme) {
        uiState.value.copy(theme = themeOption)
    }
}