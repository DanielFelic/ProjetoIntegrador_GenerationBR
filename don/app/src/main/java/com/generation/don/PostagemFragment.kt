package com.generation.don

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.don.adapter.PostagemAdapter
import com.generation.don.databinding.FragmentPostagemBinding
import com.generation.don.model.Postagem
import com.generation.don.model.Temas
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDate

class PostagemFragment : Fragment() {

    private lateinit var binding: FragmentPostagemBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var temaSelecionado = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPostagemBinding.inflate(layoutInflater, container, false)

        mainViewModel.myTemaResponse.observe(viewLifecycleOwner){
            response -> Log.d("Requisição", response.body().toString())
            spinnerTema(response.body())
        }

        mainViewModel.dataPostagem.observe(viewLifecycleOwner,{
            dataAtual -> binding.textDataHora.setText(dataAtual.toString())
        })

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
        val tema = Temas(temaSelecionado, null, null, null)
        val data = LocalDate.now()
        val dataHora = "2022-03-30T16:41:27.074Z"
        val autor = "Usuário"

        Log.d("Resposta", titulo)
        Log.d("Resposta", desc)
        Log.d("Resposta", imagem)
        Log.d("Resposta", dataHora)
        Log.d("Resposta", autor)

        if (validarCampos(titulo, desc, imagem)){
            val postagem = Postagem(
                0, titulo, desc, imagem, dataHora, autor, tema
            )
            mainViewModel.addPost(postagem)
            Toast.makeText(
                context, "Publicação realizada!",
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

    fun spinnerTema(temas: List<Temas>?){

        if (temas != null){
            binding.spinnerTema.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                temas
            )

            binding.spinnerTema.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                        val temaSelecionadoFun = binding.spinnerTema.selectedItem as Temas

                        temaSelecionado = temaSelecionadoFun.id!!
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }
        }
    }

}