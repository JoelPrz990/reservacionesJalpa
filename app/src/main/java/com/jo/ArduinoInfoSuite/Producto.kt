package com.codingstuff.loginandsignup

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "productos")
class Producto(
    val nombre:String,
    val precio: String,
    val descripcion: String,
    val fecha: String,
    val imagen: Int,
    @PrimaryKey(autoGenerate = true)
    var idProducto: Int = 0
) : Serializable