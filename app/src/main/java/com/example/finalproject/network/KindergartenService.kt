package com.example.finalproject.network

import com.example.finalproject.Model.Kindergarten
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KindergartenService {
    @GET("Kindergarten")
    fun getAllKindergarten(): Call<List<Kindergarten>>
    @GET("Kindergarten")
    fun getKindergartenBycity(@Query("city")city:String):Call<List<Kindergarten>>
}