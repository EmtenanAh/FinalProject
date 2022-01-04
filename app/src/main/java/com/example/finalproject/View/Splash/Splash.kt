package com.example.finalproject.View.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.finalproject.R
import com.example.finalproject.View.Login.Login
import com.google.firebase.messaging.FirebaseMessaging

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var tooAnimation = AnimationUtils.loadAnimation(this, R.anim.toop)
        var txt_Kindergarten = findViewById<TextView>(R.id.txt_Kindergarten)
        txt_Kindergarten.startAnimation(tooAnimation)

        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            var token = it.result.toString()
            print(token)
            val splashscteen = 5000
            val intent = Intent(this, Login::class.java)
            Handler().postDelayed({
                startActivity(intent)
                finish()
            }, splashscteen.toLong())
        }
    }
}

