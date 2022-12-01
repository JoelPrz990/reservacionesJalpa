package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nuevo_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevoProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_producto)

        var idProducto: Int? = null

        if (intent.hasExtra("producto")) {
            val producto = intent.extras?.getSerializable("producto") as Producto

            nombre_et.setText(producto.nombre)
            precio_et.setText(producto.precio.toString())
            descripcion_et.setText(producto.descripcion)
            idProducto = producto.idProducto
        }

        val database = AppDatabase.getDatabase(this)

        save_btn.setOnClickListener {
            val nombre = nombre_et.text.toString()
            val precio = precio_et.text.toString().toDouble()
            val descripcion = descripcion_et.text.toString()
            var producto = Producto(nombre, precio, descripcion, R.drawable.jalpa)

            if (nombre=="Habitacion 1" || nombre=="habitacion 1" || nombre=="1"){
                producto = Producto(nombre, precio, descripcion, R.drawable.habitacion1hacienda)

            }else{
                if (nombre=="Habitacion 2" || nombre=="habitacion 2"|| nombre=="2") {
                    producto = Producto(nombre, precio, descripcion, R.drawable.habitacion2hacienda)
                }else{
                    if (nombre=="Habitacion 3" || nombre=="habitacion 3"|| nombre=="3") {
                        producto = Producto(nombre, precio, descripcion, R.drawable.habitacion3hacienda)
                    }else{
                        if (nombre=="Habitacion 4" || nombre=="habitacion 4"|| nombre=="4") {
                            producto = Producto(nombre, precio, descripcion, R.drawable.habitacion4hacienda)
                        }else{
                            if (nombre=="Habitacion 5" || nombre=="habitacion 5"|| nombre=="5") {
                                producto = Producto(nombre, precio, descripcion, R.drawable.habitacion5hacienda)
                            }else{
                                if (nombre=="Habitacion 6" || nombre=="habitacion 6"|| nombre=="6") {
                                    producto = Producto(nombre, precio, descripcion, R.drawable.habitacion6hacienda)
                                }else{
                                    if (nombre=="LuisLong" || nombre=="luislong"|| nombre=="Luislong") {
                                        producto = Producto(nombre, precio, descripcion, R.drawable.casaluis)
                                    }else{
                                        Toast.makeText(this, "No se ha encontrado una habitacion", Toast.LENGTH_LONG).show()

                                    }
                            }


                        }


                    }

                }
            }



            if (idProducto != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    producto.idProducto = idProducto

                    database.productos().update(producto)

                    this@NuevoProductoActivity.finish()
                }
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    database.productos().insertAll(producto)

                    this@NuevoProductoActivity.finish()
                }
            }
        }
    }
}