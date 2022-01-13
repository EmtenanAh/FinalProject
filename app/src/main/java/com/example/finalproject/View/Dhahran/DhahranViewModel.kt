package com.example.finalproject.View.Dhahran

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Model.Dhahran
import com.example.finalproject.Repostory.DhahranRepository

class DhahranViewModel : ViewModel() {
    var dhahranRepository = DhahranRepository()
    fun getdhahran(): LiveData<List<Dhahran>> {
        return dhahranRepository.getAllDhahran()
    }
}
