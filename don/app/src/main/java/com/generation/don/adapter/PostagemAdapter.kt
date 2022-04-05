package com.generation.don.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.generation.don.MainViewModel
import com.generation.don.R
import com.generation.don.model.Postagem

class PostagemAdapter (
    private val postItemClickListener: PostItemClickListener,
    private val mainViewModel: MainViewModel
        ): RecyclerView.Adapter<PostagemAdapter.PostagemViewHolder>() {

    private var listaPostagens = emptyList<Postagem>()

    class PostagemViewHolder (view: View) : RecyclerView.ViewHolder(view){

        val textTitulo = view.findViewById<TextView>(R.id.textTitulo)
        val buttonDelete = view.findViewById<ImageButton>(R.id.imageButtonDelete)
        val buttonEditar = view.findViewById<ImageButton>(R.id.imageButtonEditar)
        val textAutor = view.findViewById<TextView>(R.id.textAutor)
        val textCategoria = view.findViewById<TextView>(R.id.textCategoria)
        val textImagem = view.findViewById<ImageView>(R.id.imageViewPost)
        val textDescricao = view.findViewById<TextView>(R.id.textDesc)
        val textData = view.findViewById<TextView>(R.id.textData)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostagemViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout_postagem, parent, false)

        return PostagemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PostagemViewHolder, position: Int) {
        val postagem = listaPostagens[position]

        holder.textTitulo.text = postagem.titulo
        holder.textAutor.text = postagem.autor
        holder.textCategoria.text = postagem.tema.descricao
        holder.textDescricao.text = postagem.descricao
        holder.textData.text = postagem.dataHora

        holder.buttonEditar.setOnClickListener {
            postItemClickListener.onPostClicked(postagem)
        }

        holder.buttonDelete.setOnClickListener {
            mainViewModel.deletePostagem(postagem.id)
        }

    }

    override fun getItemCount(): Int {
        return listaPostagens.size
    }

    fun setListaPost(lista: List<Postagem>){
        listaPostagens = lista
        notifyDataSetChanged()
    }

}