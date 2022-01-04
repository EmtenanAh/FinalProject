package com.example.finalproject.View.Fragment.Favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.Model.Favorite
import com.example.finalproject.R
import com.example.finalproject.Util.SharedprefHelper
import com.example.finalproject.View.Details.DetailsActivity
import com.example.finalproject.View.Dhahran.DhahranHolder
import com.squareup.picasso.Picasso

class FavoriteHolder(v: View) : RecyclerView.ViewHolder(v) {
    var image_Favorite = v.findViewById<ImageView>(R.id.image_Favorite)
    var name_Favorite = v.findViewById<TextView>(R.id.name_Favorite)
    var type_Favorite = v.findViewById<TextView>(R.id.type_Favorite)
    var icon = v.findViewById<CheckBox>(R.id.icon)
    var button_apply = v.findViewById<Button>(R.id.button_apply)
    val constraint = v.findViewById<ConstraintLayout>(R.id.constraint)

}

class FavoriteAdapter(var data: List<Favorite>) : RecyclerView.Adapter<FavoriteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_favorite, parent, false)
        return FavoriteHolder(v)
    }


    override fun onBindViewHolder(holder: FavoriteHolder, position: Int) {
        var constraint = holder.constraint.context
        Picasso.get().load(data[position].image).into(holder.image_Favorite)
        holder.name_Favorite.text = data[position].name
        holder.type_Favorite.text = data[position].type
        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context, DetailsActivity::class.java)
            i.putExtra("Favorite", data[position])
            constraint.startActivity(i)
        }
holder.icon.isChecked=true
//        holder.icon.setOnCheckedChangeListener { buttonView, isChecked ->
//            var context=holder.icon.context
//            var userId=SharedprefHelper.getUserId(context)
//            FavoriteViewModel().setFavorite(data[position],userId).observeForever{
//
//            }
//        }

    }

    override fun getItemCount(): Int {
        return data.size

    }
}