package com.example.finalproject.View.Dhahran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.finalproject.R

class DhahranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dhahran)
        val viewModel: DhahranViewModel by viewModels()
        var dhahran_recyclerview = findViewById<RecyclerView>(R.id.dhahran_recyclerview)
        dhahran_recyclerview.layoutManager = LinearLayoutManager(this)
        viewModel.getdhahran().observe(this, { list ->
            dhahran_recyclerview.adapter = DhahranAdapter(list)
        })

    }
}


