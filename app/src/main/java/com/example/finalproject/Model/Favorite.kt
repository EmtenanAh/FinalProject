package com.example.finalproject.Model

import java.io.Serializable

data class Favorite(
    val UserId: String,
    val id: String,
    val image: String,
    val name: String,
    val type: String
) : Serializable