package com.example.questao1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.questao1.databinding.ActivityQuestao3Binding
import java.time.LocalDate



//Calcular a idade de uma pessoa, tendo em vista que ela irá digitar o ano do
//seu nascimento. Evitar que o ano informado seja maior que o ano atual, ou
//menor que 1900.

class Questao3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestao3Binding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestao3Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.btnCalcularIdade.setOnClickListener {
            validarCampos()
        }

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun validarCampos() {
        if (binding.edtIdade.text.isEmpty()){
            exibirToast("Preencha o campo de idade!")
            binding.edtIdade.text.clear()
            binding.imageView.setImageResource(R.drawable.errou)
            binding.imageView.visibility = View.VISIBLE
            binding.txtIdade.text = ""
            return
        }

        val currentDate = LocalDate.now()
        val currentYear = currentDate.year

        if (binding.edtIdade.text.toString().toInt() < 1900 || binding.edtIdade.text.toString().toInt() > currentYear ){
            exibirToast("O ano deve estar entre 1900 e o ano atual")
            binding.edtIdade.text.clear()
            binding.imageView.setImageResource(R.drawable.errou)
            binding.imageView.visibility = View.VISIBLE
            binding.txtIdade.text = ""
            return
        }

        var idade = calcularIdade()

        binding.txtIdade.text = idade.toString()
        binding.imageView.setImageResource(R.drawable.acertoumiseravi)
        binding.imageView.visibility = View.VISIBLE

    }

    private fun exibirToast(mensagem: String) {
        Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calcularIdade(): Int  {
        val currentDate = LocalDate.now()
        val currentYear = currentDate.year

        return currentYear - binding.edtIdade.text.toString().toInt()
    }
}