package com.example.finalproject.network

import com.example.finalproject.Model.Kindergarten
import retrofit2.Call
import retrofit2.http.GET

interface KindergartenService {
    @GET("Kindergarten")
    fun getAllKindergarten(): Call<List<Kindergarten>>
}