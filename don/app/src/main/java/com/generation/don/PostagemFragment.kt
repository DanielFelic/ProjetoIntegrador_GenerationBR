package com.generation.don

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.don.adapter.PostagemAdapter
import com.generation.don.databinding.FragmentPostagemBinding
import com.generation.don.model.Postagem
import com.generation.don.model.Temas
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PostagemFragment : Fragment() {

    private lateinit var binding: FragmentPostagemBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPostagemBinding.inflate(layoutInflater, container, false)

        mainViewModel.myTemaResponse.observe(viewLifecycleOwner){
            response -> Log.d("Requisição", response.body().toString())
        }

        binding.ButtonPublicar.setOnClickListener {
            inserirNoBanco()
        }

        return binding.root
    }

    fun validarCampos(
        titulo: String, desc: String, imagem: String
    ): Boolean {

        return !(
                (titulo == "" || titulo.length < 3 || titulo.length > 30) ||
                        (desc == "" || desc.length < 5 || desc.length > 400) ||
                        (imagem == "" || imagem.length > 2083))
    }

    fun inserirNoBanco(){

        val titulo = binding.editTitulo.text.toString()
        val desc = binding.editDesc.text.toString()
        val imagem = binding.editLink.text.toString()
        val tema = Temas(null, null, null,
            null, null, null, null)

        if (validarCampos(titulo, desc, imagem)){
            val postagem = Postagem(
                0, titulo, desc, imagem, dataHora = String(), autor = String(), tema.toString()
            )
            mainViewModel.addPost(postagem)
            Toast.makeText(
                context, "Postagem salva!",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_postagemFragment_to_feedFragment)
        }else{
            Toast.makeText(
                context, "Preencha os campos corretamente!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}