package com.example.questao1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.example.questao1.databinding.ActivityQuestao2Binding

class Questao2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestao2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestao2Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)




        binding.btnCalcularVolume.setOnClickListener {
            if (!validarCampos()){
                Toast.makeText(this,"valores estao dentro dos conformes!!",Toast.LENGTH_LONG).show()
                openVolumePopup(this)

            }else{
                Toast.makeText(this,"DEU NUMERO ERRADO!!",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun openVolumePopup(context: Context) {
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.pop_up_volume, null)

        var volume = calculateBoxVolume(binding.edtAltura.text.toString().toDouble(),
            binding.edtLargura.text.toString().toDouble(),
            binding.edtComprimento.text.toString().toDouble()
        )

        var txtAltura = dialogView.findViewById<TextView>(R.id.txtAltura)
        var txtComprimento = dialogView.findViewById<TextView>(R.id.txtComprimento)
        var txtLargura = dialogView.findViewById<TextView>(R.id.txtLargura)
        var txtVolume = dialogView.findViewById<TextView>(R.id.txtVolume)

        txtAltura.text = "Altura:  " +  binding.edtAltura.text
        txtComprimento.text = "Comprimento:  " + binding.edtComprimento.text
        txtLargura.text ="Largura:  " +  binding.edtLargura.text
        txtVolume.text = "Volume:  " + volume.toString()

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        alertDialog.show()

        var closeTextView = dialogView.findViewById<TextView>(R.id.txtClose)
        closeTextView.setOnClickListener {
            alertDialog.dismiss()
            binding.edtLargura.text.clear()
            binding.edtComprimento.text.clear()
            binding.edtAltura.text.clear()
        }
    }

    fun calculateBoxVolume(length: Double, width: Double, height: Double): Double {
        val volume = length * width * height
        return volume
    }

    fun validarCampos(): Boolean {
        return binding.edtAltura.text.isEmpty()
                || binding.edtLargura.text.isEmpty()
                || binding.edtComprimento.text.isEmpty()
    }



}