package com.example.this_android_app.fragtwo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoViewModel: ViewModel() {
    private val _navigateTo = MutableLiveData<Boolean?>()
    val navigateTo: LiveData<Boolean?> = _navigateTo

    fun toNextFragment() {
        _navigateTo.value = true
        // Should be removed for testing
//        doneNavigating()
    }

    fun doneNavigating() {
        _navigateTo.value = false
    }
}