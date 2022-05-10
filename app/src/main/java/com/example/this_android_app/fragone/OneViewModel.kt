package com.example.this_android_app.fragone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OneViewModel: ViewModel() {
    private val _navigateTo = MutableLiveData<Boolean?>()
    val navigateTo: LiveData<Boolean?> = _navigateTo

    fun toNextFragment() {
        _navigateTo.value = true
        doneNavigating()
    }
    fun doneNavigating() {
        _navigateTo.value = false
    }
}