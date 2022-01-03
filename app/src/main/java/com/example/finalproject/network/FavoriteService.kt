package com.example.finalproject.network

import com.example.finalproject.Model.Favorite
import retrofit2.Call
import retrofit2.http.GET

interface FavoriteService {
    @GET("Favorite")
    fun getAllFavorite(): Call<List<Favorite>>
}