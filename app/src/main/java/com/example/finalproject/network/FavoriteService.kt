package com.example.finalproject.network

import com.example.finalproject.Model.Favorite
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FavoriteService {
    @GET("Favorite")
    fun getAllFavoritebyId(@Path("id")UserId:String): Call<List<Favorite>>
    @POST("Favorite")
    fun setFavorite(@Path("id")id:String, @Body F:Favorite):Call<Favorite>
}