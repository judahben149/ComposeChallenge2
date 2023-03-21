package com.example.composechallenge2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.judahben149.composechallenge.screens.DetailScreen
import com.judahben149.composechallenge.screens.MainScreen

@Composable
fun NavMain(
    navController: NavHostController,
    onToggleTheme: () -> Unit
) {

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainScreen(navController = navController, onToggleTheme = onToggleTheme)
        }

        composable("${Screen.DetailScreen.route}/{id}") {
            DetailScreen(navController = navController)
        }
    }

}