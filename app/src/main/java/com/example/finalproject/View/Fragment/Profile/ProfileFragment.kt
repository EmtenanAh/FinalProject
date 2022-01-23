package com.example.finalproject.View.Fragment.Profile

import android.app.AlertDialog
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import com.example.finalproject.Model.User
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
        val email = v.findViewById<TextView>(R.id.email)
        val phone = v.findViewById<EditText>(R.id.phone)
        val birthday = v.findViewById<EditText>(R.id.birthday)
        var save = v.findViewById<Button>(R.id.save)
        var bt_connect=v.findViewById<TextView>(R.id.bt_connect)
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
            var auth=Firebase.auth
            var name = name.text.toString()
            var email = email.text.toString()
            var phone = phone.text.toString()
            var birthday = birthday.text.toString()
if (iduser.isNotEmpty()) {
    var user=User(birthday,email, auth.currentUser?.uid.toString(),iduser,name, phone)
    viewModelProfile.updateUser(user.email,user.name,user.birthday,user.phone,user.fb_id,iduser).observeForever{
        if(it!=null){
            Toast.makeText(context, "update", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "no", Toast.LENGTH_SHORT).show()
        }
    }



}



        }
        bt_connect.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "92000100")
            startActivity(dialIntent)

        }
        return v
    }
}