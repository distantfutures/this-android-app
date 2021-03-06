package com.example.this_android_app.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _navigateToFrag = MutableLiveData<Int?>()
    val navigateToFrag: LiveData<Int?> = _navigateToFrag

    fun toNextFragment(fragNumber: Int) {
        _navigateToFrag.value = fragNumber
    }
    fun doneNavigating() {
        _navigateToFrag.value = null
    }
}