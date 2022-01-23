package com.example.finalproject.View.Details

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.finalproject.Model.Kindergarten
import com.example.finalproject.R
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val name = findViewById<TextView>(R.id.name)
        val typeD = findViewById<TextView>(R.id.typeD)
        val descriptionD = findViewById<TextView>(R.id.descriptionD)
        val emailD = findViewById<TextView>(R.id.emailD)
        val phoneD = findViewById<TextView>(R.id.phoneD)
        val location = findViewById<ImageView>(R.id.location)
        val Details = intent.getSerializableExtra("Kindergarten") as Kindergarten
        name.setText(Details.name)
        typeD.setText(Details.type)
        descriptionD.setText(Details.description)
        emailD.setText(Details.email)
        phoneD.setText(Details.phone)
        Picasso.get().load(Details.image).into(imageView)
        location.setOnClickListener {

            val gmmIntentUri = Uri.parse(Details.location)
            val intent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
        emailD.setOnClickListener {

            val i = Intent(Intent.ACTION_SEND)
            i.type = "message/Hi Little Angel Kindergarten"
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf(Details.email))
            i.putExtra(Intent.EXTRA_SUBJECT, "subject of email")
            i.putExtra(Intent.EXTRA_TEXT, "body of email")
            try {
                startActivity(Intent.createChooser(i, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
        phoneD.setOnClickListener {
         val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "920005039")
            startActivity(dialIntent)        }
    }
}