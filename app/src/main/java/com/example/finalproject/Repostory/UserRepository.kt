package com.example.finalproject.Repostory

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserRepository {
    private lateinit var auth:FirebaseAuth
    fun login(email:String,password:String):MutableLiveData<FirebaseUser>{
        auth=Firebase.auth
        var mutableLiveData=MutableLiveData<FirebaseUser>()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task->
                if (task.isSuccessful){
                    mutableLiveData.value=auth.currentUser
                }else{
                    println("error")
                }

            }
        return mutableLiveData
    }
}