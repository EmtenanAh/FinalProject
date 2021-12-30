package com.example.finalproject.View.Fragment.Profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Model.User
import com.example.finalproject.Repostory.UserRepository

class ProfileViewModel : ViewModel() {
    var userRepository = UserRepository()
    fun getUserByIDForprofile(id: String): MutableLiveData<User> {
        return userRepository.getUserByIDForprofile(id)
    }
}