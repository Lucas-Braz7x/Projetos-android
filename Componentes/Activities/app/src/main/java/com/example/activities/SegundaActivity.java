package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);

        //Recuperando os dados
        Bundle dados = getIntent().getExtras();//array com todos os dados recuperados
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");

        //(USUARIO) --> converte o objeto SERIALIZABLE em um obj Usuario
        Usuario usuario = (Usuario) dados.getSerializable("objeto");


        //Configurando os valores recuperados
        textNome.setText(usuario.getNome());
        textIdade.setText(String.valueOf(usuario.getEmail()));//SEMPRE LEMBRAR DE CONVERTER PRA STRING, SENÃO DA PAU

    }
}
