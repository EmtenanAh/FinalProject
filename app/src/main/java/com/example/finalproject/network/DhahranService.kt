package com.example.finalproject.network

import com.example.finalproject.Model.Dhahran
import retrofit2.Call
import retrofit2.http.GET

interface DhahranService {
    @GET("Dhahran")
    fun getAllProducts(): Call<List<Dhahran>>
}