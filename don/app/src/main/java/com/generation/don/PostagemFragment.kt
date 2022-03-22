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

class PostagemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_postagem, container, false)
        val buttonPublicacao = view.findViewById<ImageButton>(R.id.ButtonPublicar)


        buttonPublicacao.setOnClickListener {
            findNavController().navigate(
                R.id.action_postagemFragment_to_feedFragment
            )
        }

        return view
    }

}