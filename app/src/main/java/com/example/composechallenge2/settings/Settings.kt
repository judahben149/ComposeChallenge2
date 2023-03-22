package com.example.composechallenge2.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
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
    val onMarketingRadioClicked: (marketingOption: MarketingOptions) -> Unit =
        { viewModel.changeMarketingOptions(MarketingOptions.ALLOWED) }
    val onThemeClicked: (themeOption: Theme) -> Unit =
        { viewModel.changeTheme(Theme.FOLLOW_SYSTEM) }





    Surface {
        SettingsList(
            uiState = uiState,
            onNotificationSwitchClicked = onNotificationSwitchClicked,
            onHintCheckBoxClicked = onHintCheckBoxClicked,
            onMarketingOptionSelected = onMarketingRadioClicked,
            onThemeOptionSelected = onThemeClicked
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    uiState: State<SettingsState>,
    onNotificationSwitchClicked: () -> Unit,
    onHintCheckBoxClicked: () -> Unit,
    onMarketingOptionSelected: (marketingOption: MarketingOptions) -> Unit,
    onThemeOptionSelected: (themeOption: Theme) -> Unit
) {
    val scrollState = rememberScrollState()
    val marketingOptionSelected = uiState.value.marketingOption

    val notificationsStateText: String =
        if (uiState.value.notificationEnabled) stringResource(id = R.string.cd_notifications_enabled) else stringResource(
            id = R.string.cd_notifications_disabled
        )
    val hintsStateText: String =
        if (uiState.value.showHints) stringResource(id = R.string.cd_hints_enabled) else stringResource(
            id = R.string.cd_hints_disabled
        )

    val marketingOptions = stringArrayResource(id = R.array.marketing_emails_options)

    val selectedTheme = uiState.value.theme

    var expandedState by remember { mutableStateOf(false) }

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
                fontSize = 17.sp,
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

        Divider(modifier.padding(horizontal = 10.dp))

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
                fontSize = 17.sp,
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

        Divider(modifier.padding(horizontal = 10.dp))

        //Manage Subscription
        Row(modifier = modifier.clickable(onClickLabel = "Open Subscription Management") {
            //Lambda to navigate to this screen
        }, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Manage Subscription",
                fontSize = 17.sp,
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
                fontSize = 17.sp,
                modifier = modifier
                    .padding(start = 16.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
            )

            marketingOptions.forEachIndexed { index, option ->
                Row(modifier = modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = marketingOptionSelected.id == index,
                        role = Role.RadioButton
                    ) {

                        val optionReturned =
                            if (index == MarketingOptions.ALLOWED.id) MarketingOptions.ALLOWED else MarketingOptions.NOT_ALLOWED
                        onMarketingOptionSelected(optionReturned)
                    }
                    .padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = marketingOptionSelected.id == index,
                        onClick = null
                    )

                    Text(
                        text = option, fontSize = 14.sp, modifier = modifier
                            .weight(1f)
                            .padding(start = 12.dp)
                    )
                }
            }
        }


        //Theme Section
        Row(modifier = modifier
            .clickable {
                expandedState = true
            }
            .padding(6.dp)) {

            Text(
                text = "Theme",
                fontSize = 17.sp,
                modifier = modifier
                    .weight(1f)
                    .padding(start = 10.dp)
            )

            Text(
                text = stringResource(id = selectedTheme.title),
                fontSize = 17.sp,
                modifier = modifier
                    .clickable(onClickLabel = stringResource(id = R.string.select_theme)) {
                        expandedState = !expandedState
                    }
                    .padding(end = 10.dp)
            )

            DropdownMenu(expanded = expandedState, onDismissRequest = { expandedState = false }) {
                Theme.values().forEach { theme ->

                    DropdownMenuItem(text = {
                        Text(text = stringResource(id = theme.title))

                    }, onClick = { onThemeOptionSelected(Theme.LIGHT) })
                }
            }
        }

        SectionSpacer(modifier)

    }
}

@Composable
fun SectionSpacer(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(50.dp)
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.1f))
    ) {

    }

}


@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    Settings()
}
