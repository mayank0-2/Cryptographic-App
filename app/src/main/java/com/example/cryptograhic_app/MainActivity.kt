package com.example.cryptograhic_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptograhic_app.databinding.ActivityMainBinding
import com.lambdapioneer.argon2kt.Argon2Kt
import com.lambdapioneer.argon2kt.Argon2Mode
import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        // implementation of argon2

//        fun argon2(
//            password: ByteArray,
//            salt: ByteArray
//        ): ByteArray {
//            val argon2Kt = Argon2Kt()
//            return argon2Kt.hash(
//                mode = Argon2Mode.ARGON2_ID,
//                password = password, salt = salt,
//                tCostInIterations = 1, mCostInKibibyte = 37888
//            ).rawHashAsByteArray()
//        }

//        val argon2 = argon2()
//        val hash  = argon2(10, 65536, 2, "mayank")

        //generate key {

        val message = MessageDigest.getInstance("SHA-256")
        val bytes : ByteArray = binding.editTextTextPassword.toString().toByteArray(UTF_8)
        message.update(bytes, 0, bytes.size)
        val key : ByteArray = message.digest()
        val secretkey = SecretKeySpec(key, "AES")

        //}

        binding.Encrypt.setCheckedAnimated(false)

        // setting Encryption listners

            binding.Encrypt.onSwipedOnListener = {
                val intent = Intent(this, MainActivityencryption :: class.java)
                intent.putExtra("key", secretkey)
                startActivity(intent)
            }
        //Decryption Listner

            binding.Decrypt.onSwipedListener = {
                val intent = Intent(this, MainActivitydecryption :: class.java)
                intent.putExtra("key", binding.editTextTextPassword.toString())
                startActivity(intent)
        }

        //To send key value to encryption activity


        }
    }