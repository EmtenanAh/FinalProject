package com.example.finalproject.Repostory

import androidx.lifecycle.MutableLiveData
import com.example.finalproject.Model.Kindergarten
import com.example.finalproject.network.API
import com.example.finalproject.network.KindergartenService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KindergartenRepository {
    var mutableLiveData = MutableLiveData<List<Kindergarten>>()
    var kindergartenservice = API.getInstance().create(KindergartenService::class.java)

    fun getAllKindergarten(): MutableLiveData<List<Kindergarten>> {


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
    fun getKindergartenBycity(city:String):MutableLiveData<List<Kindergarten>>{
        val callKindergartencity= kindergartenservice.getKindergartenBycity(city)
        callKindergartencity.enqueue(object : Callback<List<Kindergarten>>{
            override fun onResponse(
                call: Call<List<Kindergarten>>,
                response: Response<List<Kindergarten>>
            ) {
mutableLiveData.postValue(response.body())            }

            override fun onFailure(call: Call<List<Kindergarten>>, t: Throwable) {
            }
        })
        return mutableLiveData
    }
}