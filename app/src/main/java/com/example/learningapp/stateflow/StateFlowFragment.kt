package com.example.learningapp.stateflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.learningapp.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch


class StateFlowFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val stateFlowViewModel: StateFlowViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            stateFlowViewModel.setStateFlowValue()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            //  and prevent from collecting data when the app is on the background
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                stateFlowViewModel.stateValue.collect {
                    binding.textviewSecond.text = "$it"
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
