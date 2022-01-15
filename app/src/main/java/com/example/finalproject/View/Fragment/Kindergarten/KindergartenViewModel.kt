package com.example.finalproject.View.Fragment.Kindergarten

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Model.Kindergarten
import com.example.finalproject.Repostory.KindergartenRepository

class KindergartenViewModel : ViewModel() {
    var KindergartenRepository = KindergartenRepository()
    fun getkindergarten(): LiveData<List<Kindergarten>> {
        return KindergartenRepository.getAllKindergarten()
    }
    fun getKindergartenBycity(city:String):LiveData<List<Kindergarten>>{
        return KindergartenRepository.getKindergartenBycity(city)
    }
}
