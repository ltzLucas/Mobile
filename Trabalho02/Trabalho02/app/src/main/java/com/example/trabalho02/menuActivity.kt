package com.example.trabalho02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabalho02.databinding.ActivityMenuBinding

class menuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavegarBuscar.setOnClickListener {

            startActivity(Intent(this   ,BuscarFonecedores::class.java))
        }

        binding.btnNavegarCadastro.setOnClickListener {
            startActivity(Intent(this   ,MainActivity::class.java))
        }
    }
}