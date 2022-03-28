package com.generation.don

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.don.adapter.PostagemAdapter
import com.generation.don.model.Postagem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PostagemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_postagem, container, false)
        val buttonPublicacao = view.findViewById<ImageButton>(R.id.ButtonPublicar)

        val editTitulo = view.findViewById<EditText>(R.id.editTitulo)
        val editDesc = view.findViewById<EditText>(R.id.editDesc)
        val editImagem = view.findViewById<EditText>(R.id.editLink)


        buttonPublicacao.setOnClickListener {

            val titulo = editTitulo.text.toString()
            val desc = editDesc.text.toString()
            val imagem = editImagem.text.toString()

            if(titulo.isEmpty() || desc.isEmpty() || imagem.isEmpty()){
                Toast.makeText(
                    context, "Preencha todos os campos",
                    Toast.LENGTH_LONG
                ).show()

            }else{
                Toast.makeText(
                    context, "Publicação salva",
                    Toast.LENGTH_LONG
                ).show()

                findNavController().navigate(
                    R.id.action_postagemFragment_to_feedFragment
                )
            }
        }
        return view
    }
}