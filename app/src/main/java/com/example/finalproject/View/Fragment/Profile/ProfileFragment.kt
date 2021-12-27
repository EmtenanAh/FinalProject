package com.example.finalproject.View.Fragment.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import com.example.finalproject.R
import com.example.finalproject.Util.SharedprefHelper

// TODO: Rename parameter arguments, choose names that match

class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var context= inflater.context
       var v= inflater.inflate(R.layout.fragment_profile, container, false)
        var name=v.findViewById<EditText>(R.id.name)
        var email=v.findViewById<EditText>(R.id.email)
        var phone=v.findViewById<EditText>(R.id.phone)
        var birthday=v.findViewById<EditText>(R.id.birthday)
        var save=v.findViewById<Button>(R.id.save)
        val viewModelProfile:ProfileViewModel by viewModels()
        val iduser= SharedprefHelper.getUserId(context)
        viewModelProfile.getUserByIDForprofile(iduser).observe(this,{
            name.setText(it.name)
            email.setText(it.email)
            phone.setText(it.phone)
            birthday.setText(it.birthday)
        })

//        save.setOnClickListener {
//
//        }
        return v
    }
}