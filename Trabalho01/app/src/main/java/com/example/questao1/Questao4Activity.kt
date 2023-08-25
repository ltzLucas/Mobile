package com.example.questao1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.questao1.databinding.ActivityQuestao4Binding

class Questao4Activity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestao4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestao4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcularConsumo.setOnClickListener {
            validarCampos()
        }

    }
    private fun validarCampos() {
        val kmText = binding.edtKm.text.toString()
        val litrosText = binding.edtLitros.text.toString()

        if (kmText.isEmpty() || litrosText.isEmpty()) {
            exibirToast("Campos não podem ser vazios")
            return
        }

        val checkedId = binding.radioGroup.checkedRadioButtonId
        if (checkedId == -1) {
            exibirToast("Selecione uma opção de KM ou Miles")
            return
        }

        when (checkedId) {
            binding.radioKm.id -> {
                var kmLitro = binding.edtKm.text.toString().toDouble() / binding.edtLitros.text.toString().toDouble()
                binding.txtresultConsumo.text = "Consumo: ${kmLitro} km/l"
            }
            binding.radioMiles.id -> {
                var kmPorLitro = binding.edtKm.text.toString().toDouble() / binding.edtLitros.text.toString().toDouble()
                var mpg = kmPorLitro * 2.35215

                binding.txtresultConsumo.text = "Consumo: ${mpg} mpg"
            }
        }

    }

    private fun exibirToast(msn : String) {
        Toast.makeText(this,"$msn", Toast.LENGTH_SHORT).show()
    }


}