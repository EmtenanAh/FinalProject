package com.example.finalproject.Repostory

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.finalproject.Model.User
import com.example.finalproject.network.API
import com.example.finalproject.network.UserService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

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
                    println("error" + task.exception?.message)
                }

            }
        return mutableLiveData
    }

    fun register(
        email: String,
        password: String,
        phone: String,
        name: String,
        birthday: String
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
                        "name" to name,
                        "image" to "",
                        "birthday" to birthday
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

    fun addUserToApi(
        fb_id: String,
        name: String,
        email: String,
        birthday: String,
        phone: String,
        id: String,
    ): MutableLiveData<User> {
        var mutableLiveData = MutableLiveData<User>()
        var userService = API.getInstance().create(UserService::class.java)
        val callAddUserToAPI = userService.addUser(
            User(birthday, email, fb_id, id, name, phone)
        )
        callAddUserToAPI.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println("error")
            }
        })
        return mutableLiveData
    }

    fun getUserByID(id: String): MutableLiveData<List<User>> {
        var mutableLiveData = MutableLiveData<List<User>>()
        val userService = API.getInstance().create(UserService::class.java)
        val callUserByFBID = userService.getUserByFBId(id)
        callUserByFBID.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println("error")
            }
        })
        return mutableLiveData
    }

    fun getUserByIDForprofile(id: String): MutableLiveData<User> {
        var mutableLiveData = MutableLiveData<User>()
        val userService = API.getInstance().create(UserService::class.java)
        val callUserByIDForProfile = userService.getUserByIDForProfile(id)
        callUserByIDForProfile.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println("error")
            }
        })
        return mutableLiveData
    }

    fun updateUser(
        name: String,
        email: String,
        birthday: String,
        phone: String,
        fb_id: String,
        id: String,
    ): MutableLiveData<User> {
        var mutableLiveData = MutableLiveData<User>()

//        val db = Firebase.firestore
//        auth = Firebase.auth
//        db.collection("users").document(auth.currentUser?.uid.toString())
//            .update(
//                "email", email,
//                "name", name,
//                "phone", phone,
//                "birthday", birthday
//            ).addOnCompleteListener {
//                if (it.isSuccessful) {
//                    val document: Void? = it.result
//                    if (document != null) {
//                        Log.d(TAG, "DocumentSnapshot data: " + it.result.toString())
//
//                    } else {
//                        Log.d(TAG, "No such document")
//                    }
//                    Toast.makeText(
//                        context,
//                        "profile has was updated Successful",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                } else {
//                    Log.d(TAG, "get failed with ", it.exception)
//
//                }
//            }

//        var user = User(birthday,email, fb_id, id, name, phone)
        var userService = API.getInstance().create(UserService::class.java)

        val calluser=userService.updateProfile(id, User(birthday, email, fb_id, id, name, phone))
        calluser.enqueue(object:Callback<User>{

            override fun onResponse(call: Call<User>, response: Response<User>) {
                mutableLiveData.postValue(response.body())
            }


            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })


        return mutableLiveData
    }

}
