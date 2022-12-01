package com.jo.ArduinoInfoSuite.Adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.LuisLong.SuperLuisLong

class LuisLongViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val superLuisLongName = view.findViewById<TextView>(R.id.tvNameL)
    val PrecioL = view.findViewById<TextView>(R.id.tvPrecioL)
    val DescripcionL = view.findViewById<TextView>(R.id.tvDescripcionL)
    val photoL = view.findViewById<ImageView>(R.id.ivHaciendaL)

    fun render(superLuisLongModel: SuperLuisLong){
        superLuisLongName.text = superLuisLongModel.nameL
        PrecioL.text = superLuisLongModel.precioL
        DescripcionL.text = superLuisLongModel.descripcionL
        Glide.with(photoL.context).load(superLuisLongModel.photoL).into(photoL)
    }
}