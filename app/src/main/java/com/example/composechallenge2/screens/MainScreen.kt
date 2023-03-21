package com.judahben149.composechallenge.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composechallenge2.components.ItemCard
import com.example.composechallenge2.data.FakeDogDatabase
import com.example.composechallenge2.navigation.Screen
import com.judahben149.composechallenge.components.TopAppBar

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onToggleTheme: () -> Unit
) {

    val dogList = FakeDogDatabase.dogList

    Surface(modifier) {
        LazyColumn {
            item {
                TopAppBar {
                    onToggleTheme.invoke()
                }
            }
            items(dogList.size) {
                dogList.forEach {
                    ItemCard(
                        it,
                        onClicked = { dog ->
                            navController.navigate("${Screen.DetailScreen.route}/${dog.id}")
                        })
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(modifier = Modifier, navController = rememberNavController()) {

    }
}