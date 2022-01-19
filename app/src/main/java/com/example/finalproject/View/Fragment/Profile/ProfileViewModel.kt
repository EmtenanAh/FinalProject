package com.example.finalproject.View.Fragment.Profile

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Model.User
import com.example.finalproject.Repostory.UserRepository

class ProfileViewModel : ViewModel() {
    var userRepository = UserRepository()
    fun getUserByIDForprofile(id: String): MutableLiveData<User> {
        return userRepository.getUserByIDForprofile(id)
    }

    fun updateUser(
        email: String,
        name: String,
        birthday: String,
        phone: String,
        fb_id: String,
        id: String,
        context: Context
    ): MutableLiveData<User> {
        return UserRepository().updateUser(name, email, birthday, phone, fb_id, id, context)
    }
}