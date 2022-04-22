package com.example.cryptograhic_app

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cryptograhic_app.databinding.ActivityMainActivityencryptionBinding
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec
import com.lambdapioneer.argon2kt.Argon2Kt
import com.lambdapioneer.argon2kt.Argon2Mode


class MainActivityencryption : AppCompatActivity() {
    private lateinit var binding1 : ActivityMainActivityencryptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityMainActivityencryptionBinding.inflate(layoutInflater)
        val view1 = binding1.root
        setContentView(view1)

        // for recieving key value from previous activity

        val p = intent.getStringExtra("key")
        val plaintext = binding1.textInput

        //for removing text from textinput
        binding1.textInput.setOnClickListener(View.OnClickListener {
            binding1.textInput.setText("")
        })


        // for encryption
        binding1.encryptbutton.setOnClickListener(View.OnClickListener {

        })

    //setting homepage default when we press back button

    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity :: class.java))
    }



}