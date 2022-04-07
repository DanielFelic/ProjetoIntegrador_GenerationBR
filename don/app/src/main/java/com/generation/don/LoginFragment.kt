package com.generation.don

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.don.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.buttonEntrar.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_feedFragment)
        }


        binding.buttonEntrarGoogle.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_feedFragment)
        }

        return binding.root
    }

}