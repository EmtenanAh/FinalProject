package com.example.finalproject.View.Registration

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Model.User
import com.example.finalproject.Repostory.UserRepository

class RegistrationViewModel : ViewModel() {
  lateinit  var registrationlivedata : MutableLiveData<User>
    fun register(email: String,
                 password: String,
                 phone: String,
                 name: String,
                 birthday:String
    ):MutableLiveData<Boolean>
    {
        var urregister = UserRepository()
        var registrationl = urregister.register(email, password, phone, name,birthday)
        return registrationl
    }
    fun addUserAPI(email: String,fb_id:String,name: String,id:String,phone: String,birthday: String){
        var urAddUserAPI=UserRepository()
        registrationlivedata=urAddUserAPI.addUserToApi(email,fb_id,name, id, phone, birthday)
    }
}
