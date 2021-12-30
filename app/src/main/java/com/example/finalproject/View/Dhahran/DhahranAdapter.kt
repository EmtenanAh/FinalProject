package com.example.finalproject.View.Dhahran

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.Model.Dhahran
import com.example.finalproject.R
import com.example.finalproject.View.Details.DetailsActivity
import com.squareup.picasso.Picasso

class DhahranHolder (v: View): RecyclerView.ViewHolder(v){
var image_kindergarten=v.findViewById<ImageView>(R.id.image_kindergarten)
    var name_kindergarten=v.findViewById<TextView>(R.id.name_kindergarten)
    var type_kindergarten=v.findViewById<TextView>(R.id.type_kindergarten)
    var image_save=v.findViewById<ImageView>(R.id.image_save)
    var button_apply=v.findViewById<Button>(R.id.button_apply)
    val constraint=v.findViewById<ConstraintLayout>(R.id.constraint)

}
class DhahranAdapter (var data:List<Dhahran>): RecyclerView.Adapter<DhahranHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DhahranHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return DhahranHolder(v)
    }


    override fun onBindViewHolder(holder: DhahranHolder, position: Int) {
        var constraint=holder.constraint.context
        Picasso.get().load(data[position].image).into(holder.image_kindergarten)
        holder.name_kindergarten.text= data[position].name
        holder.type_kindergarten.text= data[position].type
        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context,DetailsActivity::class.java)
            i.putExtra("Dhahran", data[position])
            constraint.startActivity(i)

        }
    }


    override fun getItemCount(): Int {
        return data.size
    }

}