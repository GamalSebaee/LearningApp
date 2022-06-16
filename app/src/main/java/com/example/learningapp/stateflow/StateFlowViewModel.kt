package com.example.learningapp.stateflow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StateFlowViewModel : ViewModel() {

    // init stateFlow object
    private val _stateValue = MutableStateFlow(0)
    // The UI collects from this StateFlow to get its state updates
    val stateValue: StateFlow<Int> = _stateValue

    // set value to livedata object
    fun setStateFlowValue() {
        viewModelScope.launch {
            _stateValue.emit((stateValue.value+1))
        }
    }
}
