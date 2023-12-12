package com.example.di_ejercicio_lazycolumn_scaffold

import androidx.annotation.DrawableRes

data class Juego(
    var nombre:String,
    var plataforma: String,
    @DrawableRes var portada: Int

) {
    override fun toString(): String {
        return "Nombre='$nombre'\nPlataforma='$plataforma'"
    }
}
