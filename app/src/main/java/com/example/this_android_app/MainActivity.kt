package com.example.this_android_app

import android.app.Activity
import android.content.Intent
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
import com.example.this_android_app.secondact.SecondActivity
import kotlinx.coroutines.NonCancellable.start

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var actionBarToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, binding.drawerLayout)
        binding.navigationView.setupWithNavController(navController)

        actionBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(actionBarToggle)
        actionBarToggle.syncState()
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.activity_one -> Toast.makeText(applicationContext,
                    "Viewing Activity One", Toast.LENGTH_SHORT).show()
                R.id.activity_two -> startSecondActivity()
                R.id.settings -> Toast.makeText(applicationContext,
                "Viewing Settings", Toast.LENGTH_SHORT).show()
                R.id.about -> Toast.makeText(applicationContext,
                    "Viewing About", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
    fun startSecondActivity() {
        val secondAct = Intent(this, SecondActivity::class.java)
        this.startActivity(secondAct)
        Toast.makeText(applicationContext,
            "Viewing Activity Two", Toast.LENGTH_SHORT).show()
    }
//    override fun onSupportNavigateUp()
//            = navigateUp(findNavController(R.id.nav_host_fragment), binding.drawerLayout)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}