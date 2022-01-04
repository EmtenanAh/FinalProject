package com.example.finalproject.View.Fragment.Favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.Util.SharedprefHelper


class SavedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = inflater.context
        val v = inflater.inflate(R.layout.fragment_saved, container, false)
        val favoriteViewModel:FavoriteViewModel by viewModels()
        val FavoriteRecyclerview=v.findViewById<RecyclerView>(R.id.FavoriteRecyclerview)
        FavoriteRecyclerview.layoutManager=LinearLayoutManager(context)
        var userId=SharedprefHelper.getUserId(context)
        favoriteViewModel.getFavorite(userId).observe(this,{list ->
            if (list !=null){
                FavoriteRecyclerview.adapter=FavoriteAdapter(list)
            }
        })

        return v
    }
}