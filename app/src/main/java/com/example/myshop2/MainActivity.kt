package com.example.myshop2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myshop2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //assign value binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // set content view
        setContentView(binding.root)

        //interaksi dengan binding
        with(binding) {
            // cari navigation controller dari fragment host
            val navController = findNavController(R.id.nav_host_fragment)

            // setup navigation controller ke dalam botton navigation view
            bottomNavigationView.setupWithNavController(navController)
        }
    }
}