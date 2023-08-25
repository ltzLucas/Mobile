package com.example.questao1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.questao1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)


        binding.btnQuestao1.setOnClickListener {
            var intent = Intent(this, Questao1Activity::class.java)
            startActivity(intent)
        }

        binding.btnQuestao2.setOnClickListener {
            var intent = Intent(this, Questao2Activity::class.java)
            startActivity(intent)
        }

        binding.btnQuestao3.setOnClickListener {
            var intent = Intent(this, Questao3Activity::class.java)
            startActivity(intent)
        }

        binding.btnQuestao4.setOnClickListener {
            var intent = Intent(this, Questao4Activity::class.java)
            startActivity(intent)
        }

        binding.btnQuestao5.setOnClickListener {
            var intent = Intent(this,Questao5Activity::class.java)
            startActivity(intent)
        }

        binding.btnQuestao6.setOnClickListener {
            var intent = Intent(this,Questao6Activity::class.java)
            startActivity(intent)
        }

        binding.btnQuestao7.setOnClickListener {
            var intent = Intent(this,Questao7Activity::class.java)
            startActivity(intent)
        }


    }
}