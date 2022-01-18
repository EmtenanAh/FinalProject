package com.example.finalproject.Util

import android.content.Context
import android.content.SharedPreferences

class SharedprefHelper {
    companion object {
        fun SaveUserId(context: Context, uid: String): Unit {
            var pref = context.getSharedPreferences("Mypref", Context.MODE_PRIVATE)
            pref.edit()
                .putString("id", uid).commit()
        }

        fun getUserId(context: Context): String {
            val pref = context.getSharedPreferences("Mypref", Context.MODE_PRIVATE)
            val id = pref.getString("id", "null")
            return id!!
        }
        fun clearShardPreferences(context: Context) {

            var Sharedpref : SharedPreferences = context.getSharedPreferences("SaveUserId",
                Context.MODE_PRIVATE)
            val editor = Sharedpref.edit()
            editor.putString("uid", "null")
            editor.apply()
        }
    }

}