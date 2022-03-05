package com.example.cryptograhic_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptograhic_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // setting Encryption listners
            binding.Encrypt.onSwipedOnListener = {
                val intent = Intent(this, MainActivityencryption :: class.java)
                startActivity(intent)
            }
        //Decryption Listner
            binding.Decrypt.onSwipedListener = {
                val intent = Intent(this, MainActivitydecryption :: class.java)
                startActivity(intent)
        }



        }
    }