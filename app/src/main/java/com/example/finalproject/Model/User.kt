package com.example.finalproject.Model

import java.io.Serializable

data class User(
    val birthday: String,
    val email: String,
    val fb_id: String,
    val id: String,
    val name: String,
    val phone: String
): Serializable