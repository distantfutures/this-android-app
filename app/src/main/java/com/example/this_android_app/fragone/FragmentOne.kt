package com.example.this_android_app.fragone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.this_android_app.R
import com.example.this_android_app.databinding.FragmentOneTwoBinding
import com.example.this_android_app.fragtwo.FragmentTwoArgs

private const val ARG_PARAM1 = "param1"

class FragmentOne : Fragment() {

    private lateinit var viewModel: OneViewModel
    private val args: FragmentOneArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentOneTwoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_one_two, container, false)
        viewModel = ViewModelProvider(this).get( OneViewModel::class.java)
        binding.oneViewModel = viewModel

        val data = args.stringOneData
        binding.passedData.text = data
        // Passes input data in a circle
        binding.fragmentInput.setText(data)
        binding.navigateButton.text = "Fragment 2"
        binding.navigateButton.setOnClickListener {
            viewModel.toNextFragment()
        }

        viewModel.navigateTo.observe(viewLifecycleOwner) {
            val input = binding.fragmentInput.text.toString()
//            val navController = binding.root.findNavController()
            if(it == true) {
                val action = FragmentOneDirections.actionFirstFragmentToSecondFragment(input)
                Navigation.findNavController(binding.root).navigate(action)
//                navController.navigate(R.id.action_first_fragment_to_second_fragment)
            }
        }
        return binding.root
    }
}