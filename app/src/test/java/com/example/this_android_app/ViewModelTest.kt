package com.example.this_android_app

import android.media.metrics.Event
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.this_android_app.fragtwo.TwoViewModel
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testsToNextFragment() {
        // Given - the variable
        val twoVM = TwoViewModel()
        // When - action occurs
        twoVM.toNextFragment()
        // Then - assert that...
        val value = twoVM.navigateTo.getOrAwaitValue()
        assert(value!!)
    }
    @Test
    fun testsDoneNavi() {
        // Given - the variable
        val twoVM = TwoViewModel()
        // When - action occurs
        twoVM.doneNavigating()
        // Then - assert that...
        val value = twoVM.navigateTo.getOrAwaitValue()
        assert(!value!!)
    }
}