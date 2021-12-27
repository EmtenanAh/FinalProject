package com.example.finalproject.View.Login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Repostory.UserRepository
import com.example.finalproject.Util.SharedprefHelper

class LoginViewModel:ViewModel() {

    fun login(context: Context, email: String, password: String): MutableLiveData<Boolean> {
        var loginLiveData = MutableLiveData<Boolean>()

        var userRepository = UserRepository()
        userRepository.login(email, password).observeForever {
            userRepository.getUserByID(it.uid).observeForever {
               // var userID = it[0].id
                //SharedprefHelper.SaveUserId(context, userID)
                loginLiveData.postValue(true)
            }
        }
        return loginLiveData
    }
}