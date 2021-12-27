package com.example.finalproject.View.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.finalproject.R
import com.example.finalproject.View.Dhahran.DhahranActivity

//
class NeighborhoodsFragment : Fragment() {
//
//
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v= inflater.inflate(R.layout.fragment_neighborhoods, container, false)
////        var imageViewDhahran=v.findViewById<ImageView>(R.id.imageView1`Dhahran)
////        var imageViewOlaya=v.findViewById<ImageView>(R.id.imageViewOlaya)
////        imageViewDhahran.setOnClickListener {
////            var intent= Intent(activity,DhahranActivity::class.java)
////            activity?.startActivity(intent)
////        }
        return v
//
//
    }
}