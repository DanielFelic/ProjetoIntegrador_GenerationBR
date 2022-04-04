package com.generation.don.repository

import com.generation.don.api.RetrofitInstance
import com.generation.don.model.Postagem
import com.generation.don.model.Temas
import retrofit2.Response

class Repository {

    suspend fun listTema(): Response<List<Temas>>{
        return RetrofitInstance.api.listTema()
    }

    suspend fun addPost(postagem: Postagem): Response<Postagem>{
        return RetrofitInstance.api.addPost(postagem)
    }

    suspend fun listPostagem(): Response<List<Postagem>>{
        return RetrofitInstance.api.listPostagem()
    }

    suspend fun updatePostagem(postagem: Postagem): Response<Postagem>{
        return RetrofitInstance.api.updatePostagem(postagem)
    }
}