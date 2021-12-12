package com.example.finalproject.Repostory

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserRepository {
    private lateinit var auth: FirebaseAuth
    fun login(email: String, password: String): MutableLiveData<FirebaseUser> {
        auth = Firebase.auth
        var mutableLiveData = MutableLiveData<FirebaseUser>()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mutableLiveData.value = auth.currentUser
                } else {
                    println("error")
                }

            }
        return mutableLiveData
    }

    fun register(
        email: String,
        password: String,
        phone: String,
        fullname: String
    ): MutableLiveData<Boolean> {
        var mutableLiveData = MutableLiveData<Boolean>()
        auth = Firebase.auth
      //  var db = Firebase.firestore
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val u = hashMapOf(
                        "email" to auth.currentUser?.email,
                        "phone" to phone,
                        "fullname" to fullname,
                        "image" to "",
                        "birthday" to ""
                    )
                    var db = Firebase.firestore
                    db.collection("users").document(auth.currentUser?.uid.toString())
                        .set(u).addOnCompleteListener {
                            if (it.isSuccessful) {
                                mutableLiveData.postValue(true)
                            } else {
                                mutableLiveData.postValue(false)
                            }
                        }
                } else {
                    println("Error")
                }

            }.addOnFailureListener {
                println(it.message)
            }
        return mutableLiveData

    }
}