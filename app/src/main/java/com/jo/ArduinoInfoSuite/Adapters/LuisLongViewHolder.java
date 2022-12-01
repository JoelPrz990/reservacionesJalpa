package com.jo.ArduinoInfoSuite.Adapters;

import android.view.View;

class LuisLongViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val superHaciendaName = view.findViewById<TextView>(R.id.tvName)
        val Precio = view.findViewById<TextView>(R.id.tvPrecio)
        val Descripcion = view.findViewById<TextView>(R.id.tvDescripcion)
        val photo = view.findViewById<ImageView>(R.id.ivHacienda)

        fun render(superLuisLongModel: SuperLuisLong){
        superHaciendaName.text = superHaciendaModel.name
        Precio.text = superHaciendaModel.precio
        Descripcion.text = superHaciendaModel.descripcion
        Glide.with(photo.context).load(superHaciendaModel.photo).into(photo)
        }
        }

