package com.example.composechallenge2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composechallenge2.ui.theme.BlueChip
import com.example.composechallenge2.ui.theme.RedChip

@Composable
fun GenderChip(gender: String) {
    val colorResource = if (gender == "Male") BlueChip else RedChip

    ChipView(gender = gender, colorResource = colorResource)
}

@Composable
fun ChipView(gender: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(0.2f))
    ) {
        Text(
            text = gender,
            modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp),
            color = colorResource,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GenderChipPreview() {
    GenderChip(gender = "Female")
}