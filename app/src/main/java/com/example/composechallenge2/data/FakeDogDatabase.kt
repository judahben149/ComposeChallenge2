package com.example.composechallenge2.data

import com.example.composechallenge2.Dog
import com.example.composechallenge2.DogInfo
import com.example.composechallenge2.OwnerInfo
import com.example.composechallenge2.R


object FakeDogDatabase {

    val dogInfo = DogInfo(
        4.5,
        "Gold",
        23.4,
        R.drawable.blue_dog,
        "Looking for a loving owner who would treat me right and give me all the goodies that I deserve yeahhhh"
    )

    val ownerInfo = OwnerInfo(
        "Nancy Peter",
        "Dog mum and animal lover",
        R.drawable.red_dog
    )

    val dogList = listOf(
        Dog(
            0,
            "Chunky",
            "312km",
            "23 mins",
            "Male",
            dogInfo,
            ownerInfo
        ),
        Dog(
            1,
            "Yippy",
            "435 km",
            "40 mins",
            "Female",
            dogInfo.copy(color = "Brown", weight = 20.2, imageUrl = R.drawable.white_dog),
            ownerInfo
        ),
        Dog(
            2,
            "Yippy",
            "435 km",
            "40 mins",
            "Female",
            dogInfo.copy(color = "Brown", weight = 20.2, imageUrl = R.drawable.red_dog),
            ownerInfo
        ),
        Dog(
            3,
            "Yippy",
            "435 km",
            "40 mins",
            "Female",
            dogInfo.copy(color = "Brown", weight = 20.2, imageUrl = R.drawable.yellow_dog),
            ownerInfo
        ),
        Dog(
            4,
            "Yippy",
            "435 km",
            "40 mins",
            "Female",
            dogInfo.copy(color = "Brown", weight = 20.2, imageUrl = R.drawable.orange_dog),
            ownerInfo
        ),
        Dog(
            5,
            "Yippy",
            "435 km",
            "40 mins",
            "Female",
            dogInfo.copy(color = "Brown", weight = 20.2, imageUrl = R.drawable.red_dog),
            ownerInfo
        ),
        Dog(
            6,
            "Yippy",
            "435 km",
            "40 mins",
            "Female",
            dogInfo.copy(color = "Brown", weight = 20.2, imageUrl = R.drawable.white_dog),
            ownerInfo
        ),
        Dog(
            7,
            "Yippy",
            "435 km",
            "40 mins",
            "Female",
            dogInfo.copy(color = "Brown", weight = 20.2, imageUrl = R.drawable.blue_dog),
            ownerInfo
        ),
        Dog(
            8,
            "Yippy",
            "435 km",
            "40 mins",
            "Female",
            dogInfo.copy(color = "Brown", weight = 20.2, imageUrl = R.drawable.yellow_dog),
            ownerInfo
        ),

    )
}