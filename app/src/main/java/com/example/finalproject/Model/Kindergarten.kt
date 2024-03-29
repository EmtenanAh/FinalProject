package com.example.finalproject.Model

import java.io.Serializable

data class Kindergarten(
    val city: String,
    val description: String,
    val email: String,
    val id: String,
    val image: String,
    val location: String,
    val name: String,
    val phone: String,
    val type: String
): Serializable