package com.example.finalproject.View.Dhahran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.Model.Dhahran
import com.example.finalproject.R
import com.squareup.picasso.Picasso

class DhahranHolder (v: View): RecyclerView.ViewHolder(v){
var image_kindergarten=v.findViewById<ImageView>(R.id.image_kindergarten)
    var name_kindergarten=v.findViewById<TextView>(R.id.name_kindergarten)
    var type_kindergarten=v.findViewById<TextView>(R.id.type_kindergarten)
    var image_save=v.findViewById<ImageView>(R.id.image_save)
    var button_apply=v.findViewById<Button>(R.id.button_apply)
}
class DhahranAdapter (var data:List<Dhahran>): RecyclerView.Adapter<DhahranHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DhahranHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return DhahranHolder(v)
    }


    override fun onBindViewHolder(holder: DhahranHolder, position: Int) {
        Picasso.get().load(data[position].image).into(holder.image_kindergarten)
        holder.name_kindergarten.text= data[position].name
        holder.type_kindergarten.text= data[position].type

    }


    override fun getItemCount(): Int {
        return data.size
    }

}