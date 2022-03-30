package com.generation.don.model

data class Postagem (

    val id: Long,
    val titulo: String,
    val descricao: String,
    val imagem: String,
    val dataHora: String,
    val autor: String,
    val tema: Temas) {
}