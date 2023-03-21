package com.judahben149.composechallenge.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Detail Screen", fontSize = 30.sp, modifier = modifier.clickable {
            navController.popBackStack()
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(navController = rememberNavController())
}





