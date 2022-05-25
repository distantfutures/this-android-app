package com.example.this_android_app

import android.media.metrics.Event
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.this_android_app.fragtwo.TwoViewModel
import com.example.this_android_app.main.MainViewModel
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var twoVM: TwoViewModel
    private lateinit var mainVM: MainViewModel
    @Before
    fun setUpTwoVM() {
        twoVM = TwoViewModel()
    }
    @Before
    fun setUpMainVM() {
        mainVM = MainViewModel()
    }

    @Test
    fun testsToNextFragment() {
        // When - action occurs
        twoVM.toNextFragment()
        // Then - assert that...
        val value = twoVM.navigateTo.getOrAwaitValue()
        assert(value!!) { `is`(true) }
    }
    @Test
    fun testsDoneNavi() {
        // When - action occurs
        twoVM.doneNavigating()
        // Then - assert that...
        val value = twoVM.navigateTo.getOrAwaitValue()
        assert(!value!!) { `is`(false) }
    }
    @Test
    fun testsToFragOneTwo() {
        mainVM.toNextFragment(1)
        val value = mainVM.navigateToFrag.getOrAwaitValue()
        assertThat(value, `is`(1))
    }
}