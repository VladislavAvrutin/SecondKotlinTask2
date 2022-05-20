package com.example.secondkotlintask2

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.secondkotlintask2.databinding.FragmentBoxBinding
import kotlin.random.Random


class BoxFragment: Fragment(R.layout.fragment_box) {

    private lateinit var binding: FragmentBoxBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)

        val color = requireArguments().getInt(AGR_COLOR)
        binding.root.setBackgroundColor(color)

        binding.openSecretBox.setOnClickListener(){
            findNavController().navigate(R.id.action_boxFragment_to_secretFragment,)
        }

        binding.goBack.setOnClickListener(){
            findNavController().popBackStack()
        }

        binding.generateNumber.setOnClickListener(){
            var number = Random.nextInt(100)
            parentFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(EXTRA_RANDOM_NUMBER to number))
            findNavController().popBackStack()
        }
    }


    companion object{
        const val AGR_COLOR = "color"

        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
        const val REQUEST_CODE = "RANDOM_REQUEST_COD"
    }
}