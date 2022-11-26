package com.jo.ArduinoInfoSuite.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.Models.Boards

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    private val boardsList = ArrayList<Boards>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.boards_item,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = boardsList[position]
        holder.nombre.text = currentItem.boardName
        holder.desc.text = currentItem.boardInfo
    }

    override fun getItemCount(): Int {
        return boardsList.size
    }
    fun updateBoardsList(boardsList: List<Boards>){
        this.boardsList.clear()
        this.boardsList.addAll(boardsList)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nombre : TextView = itemView.findViewById(R.id.nom)
        val desc : TextView = itemView.findViewById(R.id.desc)
    }
}