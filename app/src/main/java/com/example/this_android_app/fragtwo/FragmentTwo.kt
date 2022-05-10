package com.example.this_android_app.fragtwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.this_android_app.R
import com.example.this_android_app.databinding.FragmentOneTwoBinding

class FragmentTwo : Fragment() {

    private lateinit var viewModel: TwoViewModel
    private val args: FragmentTwoArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentOneTwoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_one_two, container, false)
        viewModel = ViewModelProvider(this).get(TwoViewModel::class.java)
        binding.twoViewModel = viewModel

        val data = args.stringTwoData
        binding.passedData.text = data

        viewModel.navigateTo.observe(viewLifecycleOwner) {
            val navController = binding.root.findNavController()
            if(it == true) {
                navController.navigate(R.id.action_second_fragment_to_first_fragment)
            }
        }
        return binding.root
    }
}