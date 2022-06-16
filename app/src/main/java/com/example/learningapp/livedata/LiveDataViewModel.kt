package com.example.learningapp.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {

    // init livedata object
    val liveDataValue = MutableLiveData<Int>()

    // set value to livedata object
    fun setLiveDataValue() {
        var value=liveDataValue.value ?: 0 //get livedata
        value++
        liveDataValue.value = value
    }
}
