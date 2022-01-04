package com.example.finalproject.Repostory

import androidx.lifecycle.MutableLiveData
import com.example.finalproject.Model.Favorite
import com.example.finalproject.network.API
import com.example.finalproject.network.FavoriteService
import com.google.protobuf.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class FavoriteRepository {
    fun setFavorite(
        id: String,
        image: String,
        name: String,
        type: String,
        UserId: String
    ):MutableLiveData<Favorite>{
        val liveData=MutableLiveData<Favorite>()
        val favoriteservice=API.getInstance().create(FavoriteService::class.java)
        favoriteservice.setFavorite(UserId, Favorite(UserId, id, image, name, type)).enqueue(object :Callback<Favorite>{
            override fun onResponse(call: Call<Favorite>, response: Response<Favorite>) {
                var favorite_1=response.body()
                liveData.postValue(response.body())
                println("favorite add")
                println(favorite_1?.UserId)
            }

            override fun onFailure(call: Call<Favorite>, t: Throwable) {
                println("Error")
            }
        })
        return liveData
    }
    fun getFavorite(UserId:String):MutableLiveData<List<Favorite>>{
        val liveData=MutableLiveData<List<Favorite>>()
        val favoriteservice=API.getInstance().create(FavoriteService::class.java)
        favoriteservice.getAllFavoritebyId(UserId).enqueue(object :Callback<List<Favorite>>{
            override fun onResponse(
                call: Call<List<Favorite>>,
                response: Response<List<Favorite>>
            ) {
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Favorite>>, t: Throwable) {

            }
        })
        return liveData
    }
}