package com.jo.ArduinoInfoSuite


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.Adapters.HaciendaAdapter

class Hacienda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hacienda)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerHacienda)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter= HaciendaAdapter(HaciendaProvider.HaciendaList)

    }


}