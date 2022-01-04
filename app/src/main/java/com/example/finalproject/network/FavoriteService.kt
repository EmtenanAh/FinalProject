package com.example.finalproject.network

import com.example.finalproject.Model.Favorite
import retrofit2.Call
import retrofit2.http.*

interface FavoriteService {
    @GET("User/{id}/Favorite")
    fun getAllFavoritebyId(@Path("id")UserId:String): Call<List<Favorite>>
    @POST("User/{id}/Favorite")
    fun setFavorite(@Path("id")id:String, @Body F:Favorite):Call<Favorite>
    @DELETE("User/{id}/Favorite")
        fun deleteFavorite(@Path("id")UserId:String): Call<Favorite>
}