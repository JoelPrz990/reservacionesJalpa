package com.jo.ArduinoInfoSuite.Adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.SuperHacienda

class HaciendaViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val superHaciendaName = view.findViewById<TextView>(R.id.tvName)
    val photo = view.findViewById<ImageView>(R.id.ivHacienda)

    fun render(superHaciendModel: SuperHacienda){
        superHaciendaName.text = superHaciendModel.name
        Glide.with(photo.context).load(superHaciendModel.photo).into(photo)
    }
}

