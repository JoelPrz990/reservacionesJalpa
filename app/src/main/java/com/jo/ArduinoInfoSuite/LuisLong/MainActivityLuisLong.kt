package com.jo.ArduinoInfoSuite.LuisLong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.Adapters.LuisLongAdapter

class MainActivityLuisLong : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_luis_long)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerLuisLong)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter= LuisLongAdapter(LuisLongProvider.LuisLongList)
    }

}