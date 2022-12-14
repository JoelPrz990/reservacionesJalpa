package com.codingstuff.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.jo.ArduinoInfoSuite.DatePickerFragment
import kotlinx.android.synthetic.main.activity_main_registro.*
import kotlinx.android.synthetic.main.activity_nuevo_producto.*
import kotlinx.android.synthetic.main.activity_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.DataOutputStream

class NuevoProductoActivity : AppCompatActivity() {


    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment{day, month, year -> OnDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun OnDateSelected(day: Int, month: Int, year: Int) {
        Date.setText("$day/$month/$year")
        //binding.etDate.setText("ha seleccionado el dia $day del mes de $month de $year")
      }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_producto)
        val btnRegistr = findViewById<Button>(R.id.etDate) as EditText
        val btnHacienda = findViewById<Button>(R.id.abrirHacienda) as Button
        val btnLuisLong = findViewById<Button>(R.id.abrirLuisLong) as Button



        //val listareservaciones = emptyList<Producto>()


        //Toast.makeText(this, "$aux", Toast.LENGTH_LONG).show()

        //dataBaseStart

        var listaproductos = emptyList<Producto>()
        val database = AppDatabase.getDatabase(this)
        val habitacion = mutableListOf<String>()
        val fecha1 = mutableListOf<String>()

        database.productos().getAll().observe(this, Observer {
            listaproductos = it
            //Llenar listas con la base de datos
            habitacion.clear()
            fecha1.clear()
            for(i in 0..(listaproductos.size-1)) {
                habitacion.add(listaproductos[i].nombre)
                fecha1.add(listaproductos[i].fecha)
            }
        })
        //dataBaseEnd








        btnLuisLong.setOnClickListener {
            val intent = Intent(this@NuevoProductoActivity, MainActivityLuisLong::class.java)
            startActivity(intent)
        }



        btnHacienda.setOnClickListener {
            val intent = Intent(this@NuevoProductoActivity, MainActivityHacienda::class.java)
            startActivity(intent)
        }



        btnRegistr.setOnClickListener {
            showDatePickerDialog()
        }

        var idProducto: Int? = null

        if (intent.hasExtra("producto")) {
            val producto = intent.extras?.getSerializable("producto") as Producto
            nombre_et.setText(producto.nombre)
            precio_et.setText(producto.precio)
            descripcion_et.setText(producto.descripcion)
            Date.setText(producto.fecha)
            idProducto = producto.idProducto
        }

        //val database = AppDatabase.getDatabase(this)

        save_btn.setOnClickListener {
            var nombre = nombre_et.text.toString()
            var precio = precio_et.text.toString()
            var fecha = Date.text.toString()
            var descripcion = descripcion_et.text.toString()
            var aux = 0
            var validacion = true

            var producto = Producto(nombre, precio, descripcion, fecha, R.drawable.jalpa)

            //Toast.makeText(this, "$habitacion", Toast.LENGTH_LONG).show()
            //Toast.makeText(this, "$fecha1", Toast.LENGTH_LONG).show()

            //Toast.makeText(this, "${fecha1[0]}", Toast.LENGTH_LONG).show() sacar

            //Toast.makeText(this, "$fecha1", Toast.LENGTH_LONG).show()

            if (nombre.isEmpty() || descripcion.isEmpty() || precio.isEmpty() || fecha.isEmpty()) {
                Toast.makeText(this, "Por favor llena todos los datos", Toast.LENGTH_LONG).show()
            } else {
                if (precio == "1" || precio == "2" || precio == "3" || precio == "4" || precio == "5" || precio == "6" || precio == "7" || precio == "8" || precio == "9" || precio == "10") {
                    if (nombre == "1" || nombre == "2" || nombre == "3" || nombre == "4" || nombre == "5" || nombre == "6" || nombre == "LuisLong" || nombre == "luislong" || nombre == "Luislong") {
                        //Realizar comparacion si existe habitacion y fecha que se repite
                            for (i in 0..(listaproductos.size - 1)) {
                                if (nombre == habitacion[i] && fecha == fecha1[i]) {

                                }else{
                                    aux++
                                }
                            }

                            if (aux!=listaproductos.size){
                                Toast.makeText(
                                    this,
                                    "Esta Ocupada ese dia y la Habitacion",
                                    Toast.LENGTH_LONG
                                ).show()
                                Toast.makeText(
                                    this,
                                    "Le recomendamos Cambiar de dia o Habitacion",
                                    Toast.LENGTH_LONG
                                ).show()

                            }else{
                                //Fuera del for
                                if (nombre == "Habitacion 1" || nombre == "habitacion 1" || nombre == "1") {
                                    producto = Producto(
                                        nombre,
                                        precio,
                                        descripcion,
                                        fecha,
                                        R.drawable.habitacion1hacienda
                                    )

                                } else {
                                    if (nombre == "Habitacion 2" || nombre == "habitacion 2" || nombre == "2") {
                                        producto = Producto(
                                            nombre,
                                            precio,
                                            descripcion,
                                            fecha,
                                            R.drawable.habitacion2hacienda
                                        )
                                    } else {
                                        if (nombre == "Habitacion 3" || nombre == "habitacion 3" || nombre == "3") {
                                            producto =
                                                Producto(
                                                    nombre,
                                                    precio,
                                                    descripcion,
                                                    fecha,
                                                    R.drawable.habitacion3hacienda
                                                )
                                        } else {
                                            if (nombre == "Habitacion 4" || nombre == "habitacion 4" || nombre == "4") {
                                                producto = Producto(
                                                    nombre,
                                                    precio,
                                                    descripcion,
                                                    fecha,
                                                    R.drawable.habitacion4hacienda
                                                )
                                            } else {
                                                if (nombre == "Habitacion 5" || nombre == "habitacion 5" || nombre == "5") {
                                                    producto = Producto(
                                                        nombre,
                                                        precio,
                                                        descripcion,
                                                        fecha,
                                                        R.drawable.habitacion5hacienda
                                                    )
                                                } else {
                                                    if (nombre == "Habitacion 6" || nombre == "habitacion 6" || nombre == "6") {
                                                        producto = Producto(
                                                            nombre,
                                                            precio,
                                                            descripcion,
                                                            fecha,
                                                            R.drawable.habitacion6hacienda
                                                        )
                                                    } else {
                                                        if (nombre == "LuisLong" || nombre == "luislong" || nombre == "Luislong") {
                                                            producto = Producto(
                                                                nombre,
                                                                precio,
                                                                descripcion,
                                                                fecha,
                                                                R.drawable.casaluis
                                                            )
                                                        } else {
                                                            Toast.makeText(
                                                                this,
                                                                "No se ha encontrado una habitacion",
                                                                Toast.LENGTH_LONG
                                                            ).show()

                                                        }
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






                    } else {
                        Toast.makeText(
                            this,
                            "No se Encontro Habitacion/LuisLong",
                            Toast.LENGTH_LONG
                        ).show()

                    }

                } else {

                    Toast.makeText(
                        this,
                        "Lo sentimos mucho, error de Numero de Personas",
                        Toast.LENGTH_LONG
                    ).show()

                }


            }


        }
    }
    }