package com.example.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class Anotacao {

    private Context context;
    private SharedPreferences preferences;

    private final String NOME_ARQUIVO = "Anotações preferências";
    private final String CHAVE_NOME = "nome";

    private SharedPreferences.Editor editor;

    public Anotacao(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,0);
        editor = preferences.edit();


    }

    public void salvar(String escrever){

        editor.putString(CHAVE_NOME, escrever);
        editor.commit();
    }

    public String recuperar(){

        return  preferences.getString(CHAVE_NOME, "");

    }

}
