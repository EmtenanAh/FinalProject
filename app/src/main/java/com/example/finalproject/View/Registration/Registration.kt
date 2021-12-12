package com.example.finalproject.View.Registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.finalproject.View.Home.HomeActivity
import com.example.finalproject.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegistrationBinding.inflate(layoutInflater)
        val viewModelregister: RegistrationViewModel by viewModels()
        binding.registration.setOnClickListener {
            viewModelregister.register(
                binding.email.text.toString(),
                binding.password.text.toString(),
                binding.phone.text.toString(),
                binding.name.text.toString(),
                this
            )
            viewModelregister.registrationlivedata.observe(this, {
                if (it == true) {
                    startActivity(Intent(this, HomeActivity::class.java))
                } else Toast.makeText(this, "wrong in registration ", Toast.LENGTH_SHORT).show()
            })
        }

        setContentView(binding.root)

    }
}