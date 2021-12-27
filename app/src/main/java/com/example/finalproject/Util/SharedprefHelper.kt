package com.example.finalproject.Util

import android.content.Context

class SharedprefHelper {
    companion object{
        fun SaveUserId(context: Context, uid:String):Unit{
            var pref=context.getSharedPreferences("Mypref",Context.MODE_PRIVATE)
            pref.edit()
                .putString("id",uid).commit()
        }
        fun getUserId(context: Context):String{
            var pref=context.getSharedPreferences("Mypref",Context.MODE_PRIVATE)
            var id=pref.getString("id","null")
            return id!!
        }
    }
}