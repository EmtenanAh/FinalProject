package com.example.finalproject.View.Login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Repostory.UserRepository
import com.google.firebase.auth.FirebaseUser

class LoginViewModel:ViewModel() {
    var loginLiveData=MutableLiveData<FirebaseUser>()
    fun login(email:String,password:String){
        var ur= UserRepository()
        loginLiveData=ur.login(email,password)
    }
}