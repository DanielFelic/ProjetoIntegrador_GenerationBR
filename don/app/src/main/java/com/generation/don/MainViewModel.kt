package com.generation.don

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.don.model.Postagem
import com.generation.don.model.Temas
import com.generation.don.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: Repository
    ): ViewModel() {

        var postagemSelecionada: Postagem? = null

        private var _myTemaResponse =
            MutableLiveData<Response<List<Temas>>>()

        val myTemaResponse: LiveData<Response<List<Temas>>> =
            _myTemaResponse

        private val _myPostagemResponse =
            MutableLiveData<Response<List<Postagem>>>()

        val myPostagemResponse: LiveData<Response<List<Postagem>>> =
            _myPostagemResponse

        val dataPostagem = MutableLiveData<LocalDate>()

    init {
        dataPostagem.value = LocalDate.now()
        listTema()
    }

    fun listTema(){
        viewModelScope.launch {
            try {
                val response = repository.listTema()
                _myTemaResponse.value = response
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun addPost(postagem: Postagem){
        viewModelScope.launch {
            try {
                val response = repository.addPost(postagem)
                Log.d("Resposta", response.body().toString())
                listPostagem()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun listPostagem(){
        viewModelScope.launch {
            try {
                val response = repository.listPostagem()
                _myPostagemResponse.value = response
            }catch (e: Exception){
                Log.e("Developer", "Error", e)
            }
        }
    }

    fun updatePostagem(postagem: Postagem){
        viewModelScope.launch {
            try {
                repository.updatePostagem(postagem)
                listPostagem()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun deletePostagem(id: Long){
        viewModelScope.launch {
            try {
                repository.deletePostagem(id)
                listPostagem()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }


}