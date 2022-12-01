package com.jo.ArduinoInfoSuite.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.SuperHacienda

class HaciendaAdapter(private val HaciendaList:List<SuperHacienda>) :RecyclerView.Adapter<HaciendaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HaciendaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HaciendaViewHolder(layoutInflater.inflate(R.layout.item_hacienda,parent,false))
    }

    override fun onBindViewHolder(holder: HaciendaViewHolder, position: Int) {
        val item = HaciendaList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return HaciendaList.size
    }
}