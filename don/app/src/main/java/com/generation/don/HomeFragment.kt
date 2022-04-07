package com.generation.don

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.don.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.buttonCadastro.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_feedFragment)
        }

        binding.buttonGoogle.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_feedFragment)
        }

        binding.buttonEntrar.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_LoginFragment)
        }

        return binding.root
    }

}