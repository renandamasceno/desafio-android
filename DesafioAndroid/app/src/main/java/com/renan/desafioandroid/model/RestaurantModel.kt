package com.renan.desafioandroid.model

data class RestaurantModel(
    val nome: String,
    val local:String,
    val hora:String,
    val imagem: Int,
    val prato:PratoModel
)