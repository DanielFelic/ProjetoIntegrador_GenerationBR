package com.generation.don.api

import com.generation.don.model.Postagem
import com.generation.don.model.Temas
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("postagem")
    suspend fun addPost(
        @Body postagem: Postagem
    ): Response<Postagem>

    @GET("postagem")
    suspend fun listPostagem() : Response<List<Postagem>>

    @GET("tema")
    suspend fun listTema(): Response<List<Temas>>

}