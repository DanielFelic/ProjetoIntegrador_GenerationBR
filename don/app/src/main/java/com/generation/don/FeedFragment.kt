package com.generation.don

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.don.adapter.PostagemAdapter
import com.generation.don.model.Postagem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)

        val buttonPost = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        buttonPost.setOnClickListener {
            findNavController().navigate(
                R.id.action_feedFragment_to_postagemFragment
            )
        }

        val listaPostagem = mutableListOf(

            Postagem(
                "Distribuição de marmitas",
                "ONG Instituto Alimentar",
                "Alimentação",
                "Link Teste",
                "Distribuição de marmitas durante a madrugada em São Paulo.",
                "21/03/2022"
            ),
            Postagem(
                "Curso de Programação",
                "ONG Generation Brasil",
                "Educação",
                "Link Teste",
                "Cursos de programação web e mobile para pessoas carentes.",
                "22/03/2022"
            ),
            Postagem(
                "Doação de cestas básicas",
                "ONG Banco de Alimentos",
                "Alimentação",
                "Link Teste",
                "Doação de cestas básicas na comunidade de Paraisópolis.",
                "23/03/2022"
            )

        )

        val recyclerPostagem = view.findViewById<RecyclerView>(R.id.recyclerPostagem)

        val adapter = PostagemAdapter()

        recyclerPostagem.layoutManager = LinearLayoutManager(context)

        recyclerPostagem.adapter = adapter

        recyclerPostagem.setHasFixedSize(true)

        adapter.setListaPost(listaPostagem)

        return view
    }

}