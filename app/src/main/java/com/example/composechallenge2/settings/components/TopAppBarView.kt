package com.example.composechallenge2.settings.components


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composechallenge2.ui.theme.sailecRegular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarView() {
    TopAppBar(title = {
        Text(text = "Settings", fontSize = 26.sp, fontFamily = sailecRegular)
    },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp, bottom = 12.dp, end = 20.dp)
                    .size(30.dp)
            )
        })
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBarView()
}
