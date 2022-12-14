package com.codingstuff.loginandsignup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.codingstuff.loginandsignup.R
import kotlinx.android.synthetic.main.activity_nuevo_producto.view.*
import kotlinx.android.synthetic.main.item_producto.view.*

class ProductosAdapter(private val mContext: Context, private val listaProductos: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)

        val producto = listaProductos[position]
        layout.nombre.text = producto.nombre
        //layout.precio.text = "${producto.precio.toString()}"
        layout.precio.text = "${producto.precio} Personas"
        //layout.Date.text = producto.fecha
        layout.imageView.setImageResource(producto.imagen)

        return layout
    }

}