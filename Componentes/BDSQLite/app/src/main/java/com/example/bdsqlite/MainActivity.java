package com.example.bdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            //Cria um banco de dados ou usa o que já tem
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criando tabelas
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3) )");

            //Inserindo dados
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Lucas', 22) ");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Jão', 45) ");

            //Recuperando as pessoas
            //As consultas aceitam os operadores lógicos ( || = OR e && = AND)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Lucas'";

            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade IN(45, 10)";//IN retorna tudo dos parentes na tablea selecionada antes se existir

            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade BETWEEN 21 AND 40"; //BETWEEN Retorna os valores entre os mencionados

            String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE 'Lu%'"; //Like = como e a porcentagem traz qualquer completação depois de LU

            Cursor cursor = bancoDados.rawQuery(consulta, null);

            int contNome = cursor.getColumnIndex("nome");
            int contIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();//Voltando para o primeiro item da lista
            while(cursor != null){

                String nome = cursor.getString(contNome);
                String idade = cursor.getString(contIdade);

                Log.i("Resultado - nome ", nome + " / Idade: " + idade);
                cursor.moveToNext();
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
