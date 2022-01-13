package com.example.finalproject.Repostory

import androidx.lifecycle.MutableLiveData
import com.example.finalproject.Model.Kindergarten
import com.example.finalproject.network.API
import com.example.finalproject.network.KindergartenService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KindergartenRepository {
    fun getAllKindergarten(): MutableLiveData<List<Kindergarten>> {

        var mutableLiveData = MutableLiveData<List<Kindergarten>>()
        var kindergartenservice = API.getInstance().create(KindergartenService::class.java)
        val callkindergartenlist = kindergartenservice.getAllKindergarten()
        callkindergartenlist.enqueue(object : Callback<List<Kindergarten>> {

            override fun onResponse(call: Call<List<Kindergarten>>, response: Response<List<Kindergarten>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(p0: Call<List<Kindergarten>>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveData

    }
}