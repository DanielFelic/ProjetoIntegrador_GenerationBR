package com.generation.don

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.don.adapter.PostagemAdapter
import com.generation.don.databinding.FragmentFeedBinding
import com.generation.don.databinding.FragmentPostagemBinding
import com.generation.don.model.Postagem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FeedFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentFeedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainViewModel.listPostagem()

        binding = FragmentFeedBinding.inflate(
            layoutInflater, container, false
        )
        val adapter = PostagemAdapter()

        binding.recyclerPostagem.layoutManager = LinearLayoutManager(context)

        binding.recyclerPostagem.adapter = adapter

        binding.recyclerPostagem.setHasFixedSize(true)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_feedFragment_to_postagemFragment)
        }

        mainViewModel.myPostagemResponse.observe(viewLifecycleOwner, {
            response -> if (response != null){
                adapter.setListaPost(response.body()!!)
            }
        })
        return binding.root
    }

}