package com.example.finalproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

        companion object{
            private  val retrofit: Retrofit
            init {
                retrofit= Retrofit.Builder()
                    .baseUrl("https://61b6f2bdc95dd70017d410fb.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            fun getInstance(): Retrofit {
                return retrofit
            }
        }

}