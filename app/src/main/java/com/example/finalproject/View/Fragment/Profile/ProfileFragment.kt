package com.example.finalproject.View.Fragment.Profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import com.example.finalproject.R
import com.example.finalproject.Util.SharedprefHelper
import com.example.finalproject.View.Login.Login
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val context = inflater.context
        val v = inflater.inflate(R.layout.fragment_profile, container, false)
        val name = v.findViewById<EditText>(R.id.name)
        val email = v.findViewById<EditText>(R.id.email)
        val phone = v.findViewById<EditText>(R.id.phone)
        val birthday = v.findViewById<EditText>(R.id.birthday)
        var save = v.findViewById<Button>(R.id.save)
        var sing_out=v.findViewById<ConstraintLayout>(R.id.sing_out)
        var userPreferences=SharedprefHelper
        sing_out.setOnClickListener {
            Firebase.auth.signOut()
            if (it != null) {
                userPreferences.clearShardPreferences(context)
            }

            var intent = Intent(activity,Login::class.java)
            activity?.startActivity(intent)
        }

        val viewModelProfile: ProfileViewModel by viewModels()
        val iduser = SharedprefHelper.getUserId(context)
        viewModelProfile.getUserByIDForprofile(iduser).observe(this, {
            name.setText(it.name)
            email.setText(it.email)
            phone.setText(it.phone)
            birthday.setText(it.birthday)

        })

        save.setOnClickListener {
            var name = name.text.toString()
            var email = email.text.toString()
            var phone = phone.text.toString()
            var birthday = birthday.text.toString()
            viewModelProfile.updateUser(email,name,birthday,phone, fb_id = String(), id = String(),context)


        }
        return v
    }
}