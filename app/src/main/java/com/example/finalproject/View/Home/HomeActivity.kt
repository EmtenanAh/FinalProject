package com.example.finalproject.View.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2
import com.example.finalproject.R
import com.example.finalproject.View.Fragment.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
      var viewPager=findViewById<ViewPager2>(R.id.viewPager)
        var tabLayout=findViewById<TabLayout>(R.id.tabLayout)
        viewPager.adapter=FragmentAdapter(this)
        var title= arrayOf("Home","Favorite","Profile")
        var icons= arrayOf(R.drawable.ic_baseline_home_24, R.drawable.ic_baseline_favorite_24,R.drawable.ic_baseline_person_24)
        TabLayoutMediator(tabLayout,viewPager){tab1,postion ->
            tab1.text=title[postion]
            tab1.setIcon(icons[postion])
        }.attach()
    }
}