package com.example.finalproject.View.Dhahran

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
import com.example.finalproject.Model.Kindergarten
import com.example.finalproject.R
import com.example.finalproject.Util.SharedprefHelper
import com.example.finalproject.View.Details.DetailsActivity
import com.example.finalproject.View.Fragment.Favorite.FavoriteViewModel
import com.squareup.picasso.Picasso

class KindergartenHolder(v: View) : RecyclerView.ViewHolder(v) {
    var image_kindergarten = v.findViewById<ImageView>(R.id.image_kindergarten)
    var name_kindergarten = v.findViewById<TextView>(R.id.name_kindergarten)
    var type_kindergarten = v.findViewById<TextView>(R.id.type_kindergarten)
    var icon_f = v.findViewById<CheckBox>(R.id.icon)
    var button_apply = v.findViewById<Button>(R.id.button_apply)
    val constraint = v.findViewById<ConstraintLayout>(R.id.constraint)

}

class KindergartenAdapter(var data: List<Kindergarten>) : RecyclerView.Adapter<KindergartenHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KindergartenHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return KindergartenHolder(v)
    }


    override fun onBindViewHolder(holder: KindergartenHolder, position: Int) {
        var constraint = holder.constraint.context
        Picasso.get().load(data[position].image).into(holder.image_kindergarten)
        holder.name_kindergarten.text = data[position].name
        holder.type_kindergarten.text = data[position].type
        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context, DetailsActivity::class.java)
            i.putExtra("Kindergarten", data[position])
            constraint.startActivity(i)
        }
        holder.icon_f.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                var userId = SharedprefHelper.getUserId(holder.itemView.context)
                FavoriteViewModel().setFavorite(
                     
                    Favorite(
                        userId,
                        data[position].id,
                        data[position].image,
                        data[position].name,
                        data[position].type
                    ), userId
                )
                holder.icon_f.isChecked = true
            } else {
                holder.icon_f.isChecked = false
            }
        }

//        holder.icon_f.setOnCheckedChangeListener { buttonView, isChecked ->
//            var context=holder.icon_f.context
//            var userId= SharedprefHelper.getUserId(context)
//            FavoriteViewModel().setFavorite(data[position],userId).observeForever{
//
//            }
//        }
    }


    override fun getItemCount(): Int {
        return data.size
    }

}