package com.codingstuff.loginandsignup


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main_registro.*

class MainActivityRegistro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_registro)

        var listaProductos = emptyList<Producto>()
        val database = AppDatabase.getDatabase(this)

        //Se utiliza para llenar toda la lista con los datos obtenidos
        database.productos().getAll().observe(this, Observer {
            listaProductos = it
            val adapter = ProductosAdapter(this, listaProductos)
            lista.adapter = adapter
        })




        //Al hacer click sobre un a lista nos devuelve estos parametros
        lista.setOnItemClickListener {parent, view, position, id ->
            //Toast.makeText(this, "${listaProductos[position].fecha}", Toast.LENGTH_LONG).show()
            //Toast.makeText(this, "${listaProductos.size}", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("id", listaProductos[position].idProducto)
            startActivity(intent)

        }


        floatingActionButton.setOnClickListener {
            val intent = Intent(this, NuevoProductoActivity::class.java)
            startActivity(intent)
        }
    }
}