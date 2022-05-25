package com.example.this_android_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.this_android_app.databinding.ActivityMainBinding
import com.example.this_android_app.main.MainFragment
import com.example.this_android_app.secondact.SecondActivity

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
        setArgs()
    }

    fun setArgs() {
        val fragTransaction = supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putString("message", "From Activity 1")
        bundle.putString("message2", "From Activity 1 Also")
        val mainFrag = MainFragment()
        mainFrag.arguments = bundle
//        fragTransaction.add(R.id.nav_host_fragment, mainFrag).commit()
        Log.i("BundleCheck", "$bundle")
    }

    private fun startSecondActivity() {
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