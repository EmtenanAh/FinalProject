package com.example.finalproject.View.Fragment.Favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Model.Favorite
import com.example.finalproject.Repostory.FavoriteRepository

class FavoriteViewModel : ViewModel() {
    var FavoriteRepository = FavoriteRepository()
    fun setFavorite(
        favorite: Favorite,
        UserId: String
    ): LiveData<Favorite> {
        val liveData = MutableLiveData<Favorite>()
        FavoriteRepository.setFavorite(favorite, UserId).observeForever {
            liveData.postValue(it)
        }
        return liveData
    }

    fun getFavorite(UserId: String): MutableLiveData<List<Favorite>> {
        val liveData = MutableLiveData<List<Favorite>>()
        FavoriteRepository.getFavorite(UserId).observeForever {
            liveData.postValue(it)
        }
        return liveData
    }

    fun deleteFavorite(
        UserId: String,
        f_id: String
    ): LiveData<Favorite> {
        val liveData = MutableLiveData<Favorite>()
        FavoriteRepository.deleteFavorite(UserId, f_id).observeForever {
            liveData.postValue(it)
        }
        return liveData
    }
}