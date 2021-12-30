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
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match

class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context= inflater.context
       val v= inflater.inflate(R.layout.fragment_profile, container, false)
        val name=v.findViewById<TextInputEditText>(R.id.name)
        val email=v.findViewById<TextInputEditText>(R.id.email)
        val phone=v.findViewById<TextInputEditText>(R.id.phone)
        val birthday=v.findViewById<TextInputEditText>(R.id.birthday)
        var save=v.findViewById<Button>(R.id.save)
        val viewModelProfile:ProfileViewModel by viewModels()
        val iduser= SharedprefHelper.getUserId(context)
        viewModelProfile.getUserByIDForprofile(iduser).observe(this,{
            phone.setText(it.phone)
            name.setText(it.name)
            birthday.setText(it.birthday)
            email.setText(it.email)

        })

//        save.setOnClickListener {
//
//        }
        return v
    }
}