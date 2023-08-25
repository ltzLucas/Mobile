package com.example.questao1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.questao1.databinding.ActivityQuestao7Binding

class Questao7Activity : AppCompatActivity() {
    lateinit var binding: ActivityQuestao7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestao7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalcularVolumeLata.setOnClickListener {

            if (validarCampos()){
                var volume = 3.14 * Math.pow(binding.edtRaio.text.toString().toDouble(),2.0) * binding.edtAlturaLata.text.toString().toDouble()
                binding.txtVolumeLata.text = "O volume da lata é de :  " + volume.toString()
            }

        }
    }


    private fun exibirToast(mensagem: String) {
        Toast.makeText(this,mensagem, Toast.LENGTH_SHORT).show()
    }
    private fun validarCampos() : Boolean {
        if (binding.edtRaio.text.isEmpty() || binding.edtAlturaLata.text.isEmpty()){
            exibirToast("Os campos nao podem ser vazios")
            binding.edtRaio.text.clear()
            binding.edtAlturaLata.text.clear()
            return false
        }
        if (binding.edtRaio.text.toString().toDouble() < 0 || binding.edtAlturaLata.text.toString().toDouble() < 0){
            exibirToast("Os campos nao podem ser negativos")
            binding.edtRaio.text.clear()
            binding.edtAlturaLata.text.clear()
            return false
        }

        return true

    }
}