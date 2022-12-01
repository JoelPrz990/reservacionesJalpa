package com.codingstuff.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.jo.ArduinoInfoSuite.Hacienda.MainActivityHacienda
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainActivityMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val btnRegistr = findViewById<Button>(R.id.btnReservar) as Button

        btnRegistr.setOnClickListener {
            val intent = Intent(this@MainActivityMenu, MainActivityRegistro::class.java)
            startActivity(intent)
        }

        /*btnHacienda = findViewById(R.id.Hacienda)
        btnLuisLong = findViewById(R.id.LuisLong)

        btnHacienda!!.setOnClickListener {
            Toast.makeText(this, "Hacienda", Toast.LENGTH_LONG).show()

        }
        btnLuisLong!!.setOnClickListener {
            Toast.makeText(this, "Luis Long", Toast.LENGTH_LONG).show()


        }*/



    }

    fun Mostrar(view: View){
        var texto=view.contentDescription.toString()
        if (texto=="LuisLong"){
            Toast.makeText(this, "Luis Long", Toast.LENGTH_LONG).show()
            val intent = Intent(this@MainActivityMenu, MainActivityHacienda::class.java)
            startActivity(intent)
        }
        if (texto=="Hacienda"){
            Toast.makeText(this, "Hacienda", Toast.LENGTH_LONG).show()
        }


    }

}