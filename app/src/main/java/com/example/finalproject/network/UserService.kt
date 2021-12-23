package com.example.finalproject.network


import com.example.finalproject.Model.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("User")
    fun getUserByFBid(@Query("fb_id") id:String): Call<List<User>>
    @PUT("User")
    fun getUserByIDForProfile(@Path ("id")id: String):Call<User>
    @POST("User")
    fun addUser(@Body u:User):Call<User>
}