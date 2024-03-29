package com.example.finalproject.View.Registration

import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.finalproject.Model.User
import com.example.finalproject.Util.RegisterValidations
import com.example.finalproject.Util.SharedprefHelper
import com.example.finalproject.View.Home.HomeActivity
import com.example.finalproject.View.Login.Login
import com.example.finalproject.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.itextpdf.text.FontFactory.register
import java.util.*

class Registration : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
        val binding = ActivityRegistrationBinding.inflate(layoutInflater)
        val viewModelregister: RegistrationViewModel by viewModels()
        val RegisterValidations = RegisterValidations()

        binding.register.setOnClickListener {
            val email = binding.email.text.toString()
            var phone = binding.phone.text.toString()
            val name = binding.name.text.toString()
            var birthday = binding.birthday.text.toString()


            val password = binding.password.text.toString()

            if (name.isNotBlank() && email.isNotBlank() && password.isNotBlank() && birthday.isNotBlank() && phone.isNotBlank()) {
                if (RegisterValidations.emailIsValid(email)) {
                    if (RegisterValidations.passwordIsValid(password)) {
                        viewModelregister.register(email, password, phone, name, birthday)
                            .observe(this, {
                                var email = binding.email.text.toString()
                                var phone = binding.phone.text.toString()
                                var name = binding.name.text.toString()
                                var birthday = binding.birthday.text.toString()
                                var fb_id = auth.currentUser?.uid.toString()
                                var user = User(birthday, email, fb_id, "1", name, phone)
                                viewModelregister.addUserAPI(
                                    email, fb_id, name, user.id, phone, birthday
                                )
                                viewModelregister.registrationlivedata.observe(this, {
                                    SharedprefHelper.SaveUserId(this, it.id)
                                    SharedprefHelper.getUserId(this)
                                    startActivity(Intent(this, HomeActivity::class.java))

                                })

                            })
                    } else
                        Toast.makeText(
                            this,
                            "Make sure your password is strong.",
                            Toast.LENGTH_SHORT
                        ).show()
                } else
                    Toast.makeText(
                        this,
                        "Make sure you typed your email address correctly.",
                        Toast.LENGTH_SHORT
                    ).show()
            } else
                Toast.makeText(
                    this,
                    "Registration fields must not be empty",
                    Toast.LENGTH_SHORT
                ).show()

        }
//            viewModelregister.register(
//                binding.email.text.toString(),
//                binding.password.text.toString(),
//                binding.phone.text.toString(),
//                binding.name.text.toString(),
//                binding.birthday.text.toString()
//            ).observe(this, {
//                var email = binding.email.text.toString()
//                var phone = binding.phone.text.toString()
//                var name = binding.name.text.toString()
//                var birthday = binding.birthday.text.toString()
//                var fb_id = auth.currentUser?.uid.toString()
//                var user = User(birthday, email, fb_id, "1", name, phone)
//                viewModelregister.addUserAPI(
//                    email, fb_id, name, user.id, phone, birthday
//                )
//                viewModelregister.registrationlivedata.observe(this, {
//                    SharedprefHelper.SaveUserId(this, it.id)
//                    SharedprefHelper.getUserId(this)
//                    startActivity(Intent(this, HomeActivity::class.java))
//
//                })
//
//            })
//        }
        binding.loginactivity1.setOnClickListener {

            var intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.birthday.setOnClickListener {


            var c = Calendar.getInstance()
            var year = c.get(Calendar.YEAR)
            var month = c.get(Calendar.MONTH)
            var day = c.get(Calendar.DAY_OF_MONTH)
            var datepickerdialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    binding.birthday.setText("$dayOfMonth/${month + 1}/$year")


                }, year, month, day
            )
            datepickerdialog.show()
        }

        setContentView(binding.root)

    }
}