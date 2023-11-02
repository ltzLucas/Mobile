package com.example.trabalho02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabalho02.databinding.ActivityMainBinding
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "FORNECEDOR" // val = constante
    private lateinit var binding: ActivityMainBinding
    private lateinit var SupplierCredentials : SupplierCredentials

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCadastrar.setOnClickListener {

            if (verificarCamposEmBranco()){
                Util.exibirToast(this,"Todos os campos devem ser preenchidos")
            }else{

                SupplierCredentials = SupplierCredentials(this,binding.edtNomeFornecedor.text.toString())

                SupplierCredentials.salvarDados(binding.edtNomeFornecedor.text.toString(),binding.edtEmailFornecedor.text.toString(),binding.edtTelefoneFornecedor.text.toString())

                binding.edtNomeFornecedor.text.clear()
                binding.edtEmailFornecedor.text.clear()
                binding.edtTelefoneFornecedor.text.clear()
                Util.exibirToast(this,"Fornecedor cadastrado com sucesso")

//                Log.d(TAG,SupplierCredentials.getNome() + SupplierCredentials.getEmail() + SupplierCredentials.getTelefone())

            }

        }


    }
    private fun verificarCamposEmBranco() : Boolean {
        return binding.edtNomeFornecedor.text.isEmpty() ||
                binding.edtEmailFornecedor.text.isEmpty() ||
                binding.edtTelefoneFornecedor.text.isEmpty()
    }
}