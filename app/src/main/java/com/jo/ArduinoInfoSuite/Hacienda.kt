package com.jo.ArduinoInfoSuite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingstuff.loginandsignup.R
import com.codingstuff.loginandsignup.databinding.ActivityHaciendaBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Hacienda : AppCompatActivity() {
    private lateinit var binding: ActivityHaciendaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@Hacienda)

        }

        fetchData()

    }

    private fun fetchData(){
        FirebaseFirestore.getInstance().collection("users")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents){
                    val user = documents.toObjects(UserModel::class.java)
                    binding.mainRecyclerview.adapter = UserAdapter(this,user)

                }

            }
            .addOnFailureListener{
                //Nosotros tendremos que realizar una impresion por si hay un error
                showToast("Ha ocurrido un error: ${it.localizedMessage}")


            }

    }
}