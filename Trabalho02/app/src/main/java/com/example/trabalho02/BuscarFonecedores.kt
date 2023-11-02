package com.example.trabalho02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabalho02.databinding.ActivityBuscarFonecedoresBinding

class BuscarFonecedores : AppCompatActivity() {

    private lateinit var binding: ActivityBuscarFonecedoresBinding
    private lateinit var supplierCredentials : SupplierCredentials
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuscarFonecedoresBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBuscar.setOnClickListener {
            supplierCredentials = SupplierCredentials(this,binding.edtNomeFornecedorBuscar.text.toString())

            var nome = supplierCredentials.getNome()
            var email = supplierCredentials.getEmail()
            var telefone = supplierCredentials.getTelefone()

            if (nome == "null" ){
                Util.exibirToast(this,"Fornecedor não encontrado")
            }else{
                binding.txtInfoFornecedor.text = "Fornecedor: $nome\n" +
                    "Email: $email\n" +
                    "Telefone: $telefone"
            }

        }
    }
}