package com.generation.don

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.don.model.Postagem
import com.generation.don.model.Temas
import com.generation.don.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    val repository: Repository
    ): ViewModel() {

        private var _myTemaResponse =
            MutableLiveData<Response<List<Temas>>>()

        val myTemaResponse: LiveData<Response<List<Temas>>> =
            _myTemaResponse

        private val _myPostagemResponse =
            MutableLiveData<Response<List<Postagem>>>()

        val myPostagemResponse: LiveData<Response<List<Postagem>>> =
            _myPostagemResponse

    init {
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
                repository.addPost(postagem)
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


}