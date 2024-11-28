package com.example.appmusica.model

import java.time.LocalDate

data class AudioMusicalExt (
    val titulo:String,
    val artist:String,
    val urlImagen : String,
    val urlAudio:String,
    val fecha:LocalDate,
    val estrellas:Double
)