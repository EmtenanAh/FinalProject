package com.example.finalproject.View.Registration

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Repostory.UserRepository

class RegistrationViewModel : ViewModel() {
    var registrationlivedata = MutableLiveData<Boolean>()
    fun register(email: String,
                 password: String,
                 phone: String,
                 fullname: String,
    context:Context
    )
    {
        var urregister = UserRepository()
        registrationlivedata = urregister.register(email, password, phone, fullname)
    }
}
