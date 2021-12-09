package com.example.finalproject.View.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.finalproject.R
import com.example.finalproject.View.Login.Login

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashscteen=5000
        val intent = Intent(this, Login::class.java)
        Handler().postDelayed({
            startActivity(intent)
            finish()
        },splashscteen.toLong())

    }
}
