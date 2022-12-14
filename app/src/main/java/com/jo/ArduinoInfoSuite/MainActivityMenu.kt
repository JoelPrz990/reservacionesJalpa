package com.codingstuff.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jo.ArduinoInfoSuite.Hacienda.FragmentHacienda

class MainActivityMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val btnRegistr = findViewById<Button>(R.id.btnReservar) as Button

        btnRegistr.setOnClickListener {
            val intent = Intent(this@MainActivityMenu, MainActivityRegistro::class.java)
            startActivity(intent)
        }




    }

    fun Mostrar(view: View){
        var texto=view.contentDescription.toString()
        if (texto=="LuisLong"){
            val intent = Intent(this@MainActivityMenu, MainActivityLuisLong1::class.java)
            startActivity(intent)
        }
        if (texto=="Hacienda"){
            val intent = Intent(this@MainActivityMenu, MainActivityHacienda1::class.java)
            startActivity(intent)

        }


    }

    /*private fun loadFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentinicio, fragment)
        fragmentTransaction.commit()
    }*/

}