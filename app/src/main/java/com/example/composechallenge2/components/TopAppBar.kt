package com.judahben149.composechallenge.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composechallenge2.R
import com.example.composechallenge2.ui.theme.RedChip
import com.example.composechallenge2.ui.theme.sailecBold

@Composable
fun TopAppBar(modifier: Modifier = Modifier, onToggle: () -> Unit) {

    Row() {

        Column(
            modifier
                .padding(10.dp)
        ) {

            Text(text = "Hey Spikey", fontFamily = sailecBold, fontSize = 20.sp)

            Spacer(modifier.height(5.dp))
            Text(text = "Would you want to adopt a pet today?", fontFamily = sailecBold)
        }

        Row(
            modifier
                .fillMaxWidth()
                .padding(end = 16.dp, top = 10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bulb_on),
                contentDescription = "Top App Bar",
                modifier
                    .size(30.dp)
                    .clickable {
                        onToggle.invoke()
                    },
                tint = RedChip
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar {

    }
}

