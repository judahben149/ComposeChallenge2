package com.example.composechallenge2.navigation

import androidx.annotation.StringRes
import com.example.composechallenge2.R

sealed class Screen(val route: String, @StringRes val details: Int) {

    object MainScreen: Screen("main", R.string.main)

    object DetailScreen: Screen("detail", R.string.detail)
}
