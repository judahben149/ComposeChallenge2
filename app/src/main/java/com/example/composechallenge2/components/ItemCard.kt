package com.example.composechallenge2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composechallenge2.Dog
import com.example.composechallenge2.R
import com.example.composechallenge2.ui.theme.BlueChip
import com.example.composechallenge2.ui.theme.RedChip
import com.example.composechallenge2.data.FakeDogDatabase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(
    dog: Dog,
    modifier: Modifier = Modifier,
    onClicked: (dog: Dog) -> Unit
) {

    Card(
        modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(10.dp)
            .background(color = Color.White)
            .clickable {
                       onClicked(dog)
            },
        shape = RoundedCornerShape(16.dp)
    ) {

        val locationIcon = painterResource(id = R.drawable.baseline_location_on_24)

        Row() {
            Image(
                painter = painterResource(id = dog.dogInfo.imageUrl),
                contentDescription = "Dog's name",
                modifier
                    .size(100.dp)
                    .padding(10.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
            )

            Spacer(modifier = modifier.width(10.dp))

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxHeight()
            ) {
                Text(text = dog.dogName, fontSize = 20.sp)
                Text(text = dog.gender, fontSize = 15.sp)

                Row(modifier = modifier.wrapContentWidth()) {
                    val iconTint = if (dog.gender == "Male") BlueChip else RedChip
                    Icon(
                        painter = locationIcon,
                        contentDescription = "location icon",
                        modifier.padding(top = 3.dp),
                        tint = iconTint
                    )
                    Spacer(modifier = modifier.width(5.dp))
                    Text(text = dog.distance, fontSize = 14.sp)
                }

            }

            Row(modifier.fillMaxSize().padding(end = 16.dp, top = 10.dp), horizontalArrangement = Arrangement.End) {

                GenderChip(gender = dog.gender)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCardPreview() {
    ItemCard(Dog(
        2,
        "Chunky",
        "312km",
        "23 mins",
        "Male",
        FakeDogDatabase.dogInfo,
        FakeDogDatabase.ownerInfo
    )) {

    }
}

