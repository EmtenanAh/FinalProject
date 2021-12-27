package com.example.finalproject.View.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.example.finalproject.R
import com.example.finalproject.View.Home.HomeActivity
import com.example.finalproject.View.Registration.Registration
import com.example.finalproject.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth=Firebase.auth
        val binding= ActivityLoginBinding.inflate(layoutInflater)
        val vm:LoginViewModel by viewModels()
        binding.login.setOnClickListener{
            vm.login(this,binding.email.text.toString(),binding.password.text.toString())
                .observe(this,{
                    startActivity(Intent(this,HomeActivity::class.java))
                })

        }
binding.registeractivity.setOnClickListener {

        var intent=Intent(this,Registration::class.java)
        startActivity(intent)


}
        setContentView(binding.root)

    }
}