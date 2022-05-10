package com.example.this_android_app.fragone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.this_android_app.R
import com.example.this_android_app.databinding.FragmentOneTwoBinding

private const val ARG_PARAM1 = "param1"

class FragmentOne : Fragment() {

    private lateinit var viewModel: OneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentOneTwoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_one_two, container, false)
        viewModel = ViewModelProvider(this).get( OneViewModel::class.java)
        binding.oneViewModel = viewModel

        viewModel.navigateTo.observe(viewLifecycleOwner) {
            val navController = binding.root.findNavController()
            if(it == true) {
                navController.navigate(R.id.action_first_fragment_to_second_fragment)
            }
        }
        return binding.root
    }
}