package com.generation.don.api

import com.generation.don.model.Postagem
import com.generation.don.model.Temas
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("postagens")
    suspend fun addPost(
        @Body postagem: Postagem
    ): Response<Postagem>

    @GET("postagens")
    suspend fun listPostagem() : Response<List<Postagem>>

    @GET("temas")
    suspend fun listTema(): Response<List<Temas>>

    @PUT("postagens")
    suspend fun updatePostagem(
        @Body postagem: Postagem
    ): Response<Postagem>

    @DELETE("postagens/{id}")
    suspend fun deletePostagem(
        @Path("id") valor: Long
    ): Response<Postagem>




}