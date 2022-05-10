package com.example.this_android_app.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.this_android_app.R
import com.example.this_android_app.databinding.FragmentMainBinding

private const val ARG_PARAM1 = "param1"

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_main, container, false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainViewModel = viewModel

        viewModel.navigateToFrag.observe(viewLifecycleOwner) {
            val input = binding.mainFragInput.text.toString()
//            val navController = binding.root.findNavController()
            if(it == 1) {
                val action = MainFragmentDirections.actionMainFragmentToFirstFragment(input)
                Navigation.findNavController(binding.root).navigate(action)
//                navController.navigate(R.id.action_mainFragment_to_first_fragment)
            }
            if(it == 2) {
                val action = MainFragmentDirections.actionMainFragmentToFirstFragment(input)
                Navigation.findNavController(binding.root).navigate(action)
//                navController.navigate(R.id.action_main_fragment_to_second_fragment)
            }
            else {

            }
        }
        return binding.root
    }
}