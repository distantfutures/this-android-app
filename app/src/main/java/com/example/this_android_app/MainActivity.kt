package com.example.this_android_app

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.this_android_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
//    lateinit var actionBarToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, binding.drawerLayout)
        binding.navigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener {_, destination: NavDestination, _ ->
            val toolbar = supportActionBar ?: return@addOnDestinationChangedListener
            when(destination.id) {
                R.id.activity_one -> {
                    toolbar.setDisplayShowTitleEnabled(false)
                }
                R.id.activity_two -> {
                    toolbar.setDisplayShowTitleEnabled(false)
                }
                else -> {
                    toolbar.setDisplayShowTitleEnabled(true)
                }
            }
        }
//        actionBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
//        binding.drawerLayout.addDrawerListener(actionBarToggle)
//        actionBarToggle.syncState()
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        binding.navigationView.setNavigationItemSelectedListener {
//            when(it.itemId) {
//                R.id.settings -> Toast.makeText(applicationContext,
//                "Clicked Main Fragment", Toast.LENGTH_SHORT).show()
//                R.id.about -> Toast.makeText(applicationContext,
//                    "Clicked Main Fragment", Toast.LENGTH_SHORT).show()
//            }
//            true
//        }
    }
    override fun onSupportNavigateUp()
            = navigateUp(findNavController(R.id.nav_host_fragment), binding.drawerLayout)

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (actionBarToggle.onOptionsItemSelected(item)) {
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }
}