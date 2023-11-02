package com.example.trabalho02

import android.content.Context
import android.widget.Toast

class Util {
    companion object {

        val CHAVE_EMAIL = "email"
        val CHAVE_NOME  = "nome"
        val CHAVE_TELEFONE = "telefone"
        val NULL = "null"

        // exibe um toast com base no contexto e string recebidos via parametro
        fun exibirToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}