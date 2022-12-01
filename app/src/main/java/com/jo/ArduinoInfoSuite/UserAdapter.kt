package com.codingstuff.loginandsignup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.UserModel

class UserAdapter(private val context: Context, private val users: List<UserModel>):RecyclerView.Adapter<UserViewHolder> (){
    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(

            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = users[position]
        holder.userName.text = user.userName


        //Las Imagenes Trabajaran con GLIDE
        Glide.with(context)
            .load(user.userImage)
            .into(holder.userImage)
    }

}

class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val userName:TextView = itemView.findViewById(R.id.textView_username)
    val userImage:ImageView = itemView.findViewById(R.id.imageView_user)
}