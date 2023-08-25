package com.example.questao1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.questao1.databinding.ActivityQuestao5Binding



class Questao5Activity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestao5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestao5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcularMedia.setOnClickListener {

            if (validarCampos()){
                openPopUp(this)
            }
        }

    }

    private fun validarCampos() : Boolean {

        if (binding.edtNota01.text.isEmpty() ||binding.edtNota02.text.isEmpty()
            ||binding.edtNota03.text.isEmpty() || binding.edtNota04.text.isEmpty()){
            exibirToast("Todos os campos devem ser preenchidos")
            binding.edtNota01.text.clear()
            binding.edtNota02.text.clear()
            binding.edtNota03.text.clear()
            binding.edtNota04.text.clear()
            return false
        }
        if (binding.edtNota01.text.toString().toDouble() < 0 || binding.edtNota02.text.toString().toDouble() < 0
            || binding.edtNota03.text.toString().toDouble() < 0 || binding.edtNota04.text.toString().toDouble() < 0) {
            exibirToast("As notas devem ser maiores que 0")
            binding.edtNota01.text.clear()
            binding.edtNota02.text.clear()
            binding.edtNota03.text.clear()
            binding.edtNota04.text.clear()
            return false
        }
        if (binding.edtNota01.text.toString().toDouble() > 10 || binding.edtNota02.text.toString().toDouble() > 10
            || binding.edtNota03.text.toString().toDouble() > 10 || binding.edtNota04.text.toString().toDouble() > 10) {
            exibirToast("As notas devem ser menores que 10")
            binding.edtNota01.text.clear()
            binding.edtNota02.text.clear()
            binding.edtNota03.text.clear()
            binding.edtNota04.text.clear()
            return false
        }

        return true

    }

    private fun exibirToast(mensagem: String) {
        Toast.makeText(this,mensagem, Toast.LENGTH_SHORT).show()
    }

    fun openPopUp(context: Context){
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.pop_up_media, null)

        var media = calcularMedia()

        var txtMedia = dialogView.findViewById<TextView>(R.id.txtMediaFinal)

        txtMedia.text = media.toString()

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        alertDialog.show()

    }

    fun calcularMedia(): Double{
        return  (binding.edtNota01.text.toString().toDouble() +
                binding.edtNota02.text.toString().toDouble() +
                binding.edtNota03.text.toString().toDouble() +
                binding.edtNota04.text.toString().toDouble()) / 4
    }
}