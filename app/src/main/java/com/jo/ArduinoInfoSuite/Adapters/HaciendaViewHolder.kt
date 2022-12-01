package com.jo.ArduinoInfoSuite.Adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.SuperHacienda

class HaciendaViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val superHaciendaName = view.findViewById<TextView>(R.id.tvName)
    val Precio = view.findViewById<TextView>(R.id.tvPrecio)
    val Descripcion = view.findViewById<TextView>(R.id.tvDescripcion)
    val photo = view.findViewById<ImageView>(R.id.ivHacienda)

    fun render(superHaciendaModel: SuperHacienda){
        superHaciendaName.text = superHaciendaModel.name
        Precio.text = superHaciendaModel.precio
        Descripcion.text = superHaciendaModel.descripcion
        Glide.with(photo.context).load(superHaciendaModel.photo).into(photo)
    }
}

