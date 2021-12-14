package com.example.finalproject.Repostory

import androidx.lifecycle.MutableLiveData
import com.example.finalproject.Model.Dhahran
import com.example.finalproject.network.API
import com.example.finalproject.network.DhahranService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DhahranRepository {
    fun getAllDhahran(): MutableLiveData<List<Dhahran>> {

        var mutableLiveData = MutableLiveData<List<Dhahran>>()
        var dhahranservice= API.getInstance().create(DhahranService::class.java)
        val calldhahranlist=dhahranservice.getAllDhahran()
        calldhahranlist.enqueue(object : Callback<List<Dhahran>> {

            override fun onResponse(call: Call<List<Dhahran>>, response: Response<List<Dhahran>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(p0: Call<List<Dhahran>>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveData

    }
}