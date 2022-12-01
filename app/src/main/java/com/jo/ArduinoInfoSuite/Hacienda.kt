package com.codingstuff.loginandsignup


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.databinding.ActivityHaciendaBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.jo.ArduinoInfoSuite.Adapters.HaciendaAdapter
import com.jo.ArduinoInfoSuite.HaciendaProvider
import com.jo.ArduinoInfoSuite.SuperHacienda
import com.jo.ArduinoInfoSuite.showToast

class Hacienda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hacienda)
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewHacienda)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter=HaciendaAdapter(HaciendaProvider.HaciendaList)

    }


}