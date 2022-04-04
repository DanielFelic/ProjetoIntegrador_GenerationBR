package com.generation.don.adapter

import com.generation.don.model.Postagem

interface PostItemClickListener {

    fun onPostClicked(postagem: Postagem)
}