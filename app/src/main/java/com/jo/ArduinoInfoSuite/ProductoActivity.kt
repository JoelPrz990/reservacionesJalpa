package com.codingstuff.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.codingstuff.loginandsignup.AppDatabase
import com.codingstuff.loginandsignup.NuevoProductoActivity
import com.codingstuff.loginandsignup.Producto
import com.codingstuff.loginandsignup.R
import kotlinx.android.synthetic.main.activity_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductoActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var producto: Producto
    private lateinit var productoLiveData: LiveData<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        database = AppDatabase.getDatabase(this)

        val idProducto = intent.getIntExtra("id", 0)

        productoLiveData = database.productos().get(idProducto)

        productoLiveData.observe(this, Observer {
            producto = it
            nombre_producto.text = "LuisLong/Habitacion: ${producto.nombre}"
            precio_producto.text = "Personas: ${producto.precio}"
            detalles_producto.text = "Nombre: ${producto.descripcion}"
            fechas.text = "Fecha: ${producto.fecha}"
            imagen.setImageResource(producto.imagen)

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.producto_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.edit_item -> {
                val intent = Intent(this, NuevoProductoActivity::class.java)
                intent.putExtra("producto", producto)
                startActivity(intent)
            }

            R.id.delete_item -> {
                productoLiveData.removeObservers(this)
                CoroutineScope(Dispatchers.IO).launch {
                    database.productos().delete(producto)
                    this@ProductoActivity.finish()
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}