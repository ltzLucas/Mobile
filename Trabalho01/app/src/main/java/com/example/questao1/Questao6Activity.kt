package com.example.questao1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.questao1.databinding.ActivityQuestao6Binding

class Questao6Activity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestao6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestao6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.seekBarGraus.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                binding.txtGrausCelsius.text = "$progress ºC"
                var Fahrenheit = (9*progress + 160) / 5
                binding.txtFahrenheit.text = Fahrenheit.toString() + "ºF"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

    }



    private fun converteCelsiusEmFahren() : Double {
        return 2.2
    }
}