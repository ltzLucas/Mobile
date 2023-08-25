package com.example.questao1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import com.example.questao1.databinding.ActivityQuestao1Binding


//        Calcular o aumento que será dado a um funcionário, obtendo do usuário as
//        seguintes informações: salário atual e a porcentagem de aumento. Apresentar
//                o novo valor do salário e o valor do aumento.


class Questao1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestao1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestao1Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.edtSalarioAtual.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This method is called before the text changes.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!validarCampoVazio()){

                    binding.txtNovoSalario.text = binding.edtSalarioAtual.text
                }else {
                    binding.txtNovoSalario.text = "0,00"
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // This method is called after the text changes.
            }
        })



        binding.sBarPercent.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                binding.txtProgress.text = "$progress %"
                if(!validarCampoVazio()){
                    var aumento = (progress * binding.edtSalarioAtual.text.toString().toDouble()) / 100.0
                    var formattedAumento = String.format("%.2f", aumento)
                    binding.txtAumento.text = "R$ $formattedAumento"

                    var novoSalario = binding.edtSalarioAtual.text.toString().toDouble() + aumento

                    binding.txtNovoSalario.text = "R$ $novoSalario"

                }else{
                    binding.txtAumento.text = "0,00"
                    binding.txtNovoSalario.text = "0,00"
                }


            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })


    }
        private fun validarCampoVazio() : Boolean {
            return binding.edtSalarioAtual.text.isEmpty()
        }
}