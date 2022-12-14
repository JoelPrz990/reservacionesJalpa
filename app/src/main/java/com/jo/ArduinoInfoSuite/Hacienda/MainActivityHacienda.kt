package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.Adapters.HaciendaAdapter
import com.jo.ArduinoInfoSuite.Hacienda.HaciendaProvider

class MainActivityHacienda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hacienda)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerHacienda)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter= HaciendaAdapter(HaciendaProvider.HaciendaList)
    }
}

