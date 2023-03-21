package com.example.composechallenge2


data class Dog(
    val id: Int,
    val dogName: String,
    val distance: String,
    val eta: String,
    val gender: String,
    val dogInfo: DogInfo,
    val ownerInfo: OwnerInfo
)

data class DogInfo(
    val age: Double,
    val color: String,
    val weight: Double,
    val imageUrl: Int,
    val description: String
)

data class OwnerInfo(
    val name: String,
    val description: String,
    val imageUrl: Int
    )
