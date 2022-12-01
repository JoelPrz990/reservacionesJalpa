package com.jo.ArduinoInfoSuite


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.Toast
import com.codingstuff.loginandsignup.R

class MainActivityMenu : AppCompatActivity() {
    var btnHacienda: Button?=null
    var btnLuisLong: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

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
        }else{
            Toast.makeText(this, "Hacienda", Toast.LENGTH_LONG).show()

        }

    }

}