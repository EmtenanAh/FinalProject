package com.example.finalproject.View.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.finalproject.R
import com.example.finalproject.View.Neighborhoods.Neighborhoods
import com.example.finalproject.View.Profile.ProfileActivity
import com.example.finalproject.View.Registration.Registration
import com.example.finalproject.View.saved.SavedActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var neighborhoods=findViewById<ImageView>(R.id.neighborhoods)
        var saved=findViewById<ImageView>(R.id.saved)
        var profile=findViewById<ImageView>(R.id.profile)
        neighborhoods.setOnClickListener {
            var intent=Intent(this, Neighborhoods::class.java)
            startActivity(intent)

        }
        saved.setOnClickListener {
            var intent=Intent(this, SavedActivity::class.java)
            startActivity(intent)

        }
        profile.setOnClickListener {
            var intent=Intent(this, ProfileActivity::class.java)
            startActivity(intent)


        }
    }
}