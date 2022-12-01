package com.jo.ArduinoInfoSuite.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.Hacienda.SuperHacienda
import com.jo.ArduinoInfoSuite.LuisLong.SuperLuisLong

class LuisLongAdapter(private val LuisLongList:List<SuperLuisLong>) : RecyclerView.Adapter<LuisLongViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LuisLongViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LuisLongViewHolder(layoutInflater.inflate(R.layout.item_luislong,parent,false))
    }

    override fun onBindViewHolder(holder: LuisLongViewHolder, position: Int) {
        val item = LuisLongList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return LuisLongList.size
    }
}