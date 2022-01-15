package com.example.finalproject.View.Fragment.Favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.Util.SharedprefHelper
import com.example.finalproject.Util.SwipeToDeleteCallback


class FavoriteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = inflater.context
        val v = inflater.inflate(R.layout.fragment_favorite, container, false)
        val favoriteViewModel: FavoriteViewModel by viewModels()
        val FavoriteRecyclerview = v.findViewById<RecyclerView>(R.id.FavoriteRecyclerview)
        FavoriteRecyclerview.layoutManager = LinearLayoutManager(context)
        var userId = SharedprefHelper.getUserId(context)
        favoriteViewModel.getFavorite(userId).observe(this, { list ->
           // if (list != null) {
            var favorite = list.toMutableList()
            FavoriteRecyclerview.adapter = FavoriteAdapter(favorite)
            var swipe = object : SwipeToDeleteCallback(context) {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    super.onSwiped(viewHolder, direction)
                    val position = viewHolder.position
                    favoriteViewModel.deleteFavorite(userId, favorite[position].id)
                        .observe(this@FavoriteFragment, {
                            favorite.removeAt(position)
                            FavoriteRecyclerview.adapter?.notifyItemRemoved(position)
                        })

                }
            }

            val touchHelper = ItemTouchHelper(swipe)
            touchHelper.attachToRecyclerView(FavoriteRecyclerview)
            //   }
        })

        return v
    }
}
