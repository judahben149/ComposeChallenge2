package com.example.composechallenge2.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composechallenge2.R
import com.example.composechallenge2.settings.components.TopAppBarView

@Composable
fun Settings() {

    val viewModel: SettingsViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState()
    val onNotificationSwitchClicked: () -> Unit = { viewModel.toggleNotifications() }
    val onHintCheckBoxClicked: () -> Unit = { viewModel.toggleHintOptions() }
    val onMarketingRadioClicked: () -> Unit =
        { viewModel.changeMarketingOptions(MarketingOptions.ALLOWED) }
    val onThemeClicked: () -> Unit = { viewModel.changeTheme(Theme.FOLLOW_SYSTEM) }



    Surface {
        SettingsList(
            uiState = uiState,
            onNotificationSwitchClicked = onNotificationSwitchClicked,
            onHintCheckBoxClicked = onHintCheckBoxClicked,
            onMarketingRadioClicked = onMarketingRadioClicked,
            onThemeClicked = onThemeClicked
        )
    }
}


@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    uiState: State<SettingsState>,
    onNotificationSwitchClicked: () -> Unit,
    onHintCheckBoxClicked: () -> Unit,
    onMarketingRadioClicked: () -> Unit,
    onThemeClicked: () -> Unit
) {
    val scrollState = rememberScrollState()
    val marketingOptionSelected: Boolean = when (uiState.value.marketingOption.id) {
        MarketingOptions.ALLOWED.id -> true
        else -> false
    }

    val notificationsStateText: String =
        if (uiState.value.notificationEnabled) stringResource(id = R.string.cd_notifications_enabled) else stringResource(
            id = R.string.cd_notifications_disabled
        )
    val hintsStateText: String =
        if (uiState.value.showHints) stringResource(id = R.string.cd_hints_enabled) else stringResource(
            id = R.string.cd_hints_disabled
        )

    Column(
        modifier = modifier
            .fillMaxSize()
            .scrollable(scrollState, orientation = Orientation.Vertical)
    ) {
        TopAppBarView()

        //Notifications Switch
        Row(
            modifier = modifier
                .toggleable(
                    value = uiState.value.notificationEnabled,
                    onValueChange = { onNotificationSwitchClicked() },
                    role = Role.Switch
                )
                .semantics {
                    stateDescription = notificationsStateText
                }, verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Enable Notifications",
                fontSize = 20.sp,
                modifier = modifier
                    .padding(start = 16.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
                    .weight(1f)
            )
            Switch(
                modifier = modifier.padding(16.dp),
                checked = uiState.value.notificationEnabled,
                onCheckedChange = null
            )
        }

        Divider()

        //Hint CheckBox
        Row(
            modifier = modifier
                .toggleable(
                    value = uiState.value.showHints,
                    onValueChange = { onHintCheckBoxClicked() },
                    role = Role.Checkbox
                )
                .semantics {
                    stateDescription = hintsStateText
                }, verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Show Hints",
                fontSize = 20.sp,
                modifier = modifier
                    .padding(start = 16.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
                    .weight(1f)
            )
            Checkbox(
                modifier = modifier.padding(16.dp),
                checked = uiState.value.showHints,
                onCheckedChange = null
            )
        }

        Divider()

        //Manage Subscription
        Row(modifier = modifier.clickable(onClickLabel = "Open Subscription Management") {
            //Lambda to navigate to this screen
        }, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Manage Subscription",
                fontSize = 20.sp,
                modifier = modifier
                    .padding(start = 16.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
                    .weight(1f)
            )
            Icon(
                modifier = modifier
                    .padding(20.dp)
                    .size(30.dp),
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }

        Divider(modifier.padding(horizontal = 10.dp))

        SectionSpacer(modifier)

        //Receive marketing emails
        Column {
            Text(
                text = "Receive marketing emails?",
                fontSize = 20.sp,
                modifier = modifier
                    .padding(start = 16.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
            )

            RadioButton(selected = marketingOptionSelected, onClick = { })

        }

        SectionSpacer(modifier)


    }
}

@Composable
fun SectionSpacer(modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .height(50.dp)
        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.3f))) {

    }
    
}


@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    Settings()
}
