package com.example.trabalho02

import android.content.Context

class SupplierCredentials(context: Context, nome: String) {

    private var sharedPreferences = context.getSharedPreferences(nome ,Context.MODE_PRIVATE)

    fun salvarDados(nome: String, email: String, telefone: String){
        sharedPreferences.edit()
            .putString(Util.CHAVE_NOME,nome)
            .putString(Util.CHAVE_EMAIL,email)
            .putString(Util.CHAVE_TELEFONE,telefone)
            .apply()

    }

    fun getNome() : String{
        return sharedPreferences.getString(Util.CHAVE_NOME, Util.NULL) ?: ""
    }
    fun getEmail() : String{
        return sharedPreferences.getString(Util.CHAVE_EMAIL, Util.NULL) ?: ""
    }
    fun getTelefone() : String{
        return sharedPreferences.getString(Util.CHAVE_TELEFONE, Util.NULL) ?: ""
    }

    fun limparDados() {
        sharedPreferences.edit()
            .remove(Util.CHAVE_EMAIL)
            .remove(Util.CHAVE_NOME)
            .remove(Util.CHAVE_TELEFONE)
            .apply()
    }

}