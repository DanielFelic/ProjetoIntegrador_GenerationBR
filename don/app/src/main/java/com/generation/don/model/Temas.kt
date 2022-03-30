package com.generation.don.model

data class Temas (
    val id: Long?,
    val titulo: String?,
    val descricao: String?,
    val postagens: List<Postagem>?
    ) {

    override fun toString(): String{
        return descricao!!
    }
}



