package com.example.learningapp.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.learningapp.R
import com.example.learningapp.databinding.FragmentFirstBinding

class LiveDataFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val liveDataViewModel: LiveDataViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.buttonCheck.setOnClickListener {
            liveDataViewModel.setLiveDataValue()
        }
        // you can use this style to observe live data changes
        liveDataViewModel.liveDataValue.observe(viewLifecycleOwner) { value ->
            binding.textviewFirst.text = "$value"
        }

        /*
        // or you can use this style to observe live data changes
        val liveDataValue = Observer<Int> { value ->
            binding.textviewFirst.text = "$value"
        }
        liveDataViewModel.liveDataValue.observe(viewLifecycleOwner, liveDataValue)*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
