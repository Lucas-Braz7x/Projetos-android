package com.example.minhasanotacoes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Anotacao anotacao;
    private EditText editAnotacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);

        anotacao = new Anotacao(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validação
                if(editAnotacao.getText().toString().equals("")){
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                }else{
                    anotacao.salvar(editAnotacao.getText().toString());
                    Snackbar.make(view, "Salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        //Recuperando a anotação
        String anotacao2 = anotacao.recuperar();
        if(!anotacao2.equals("")){
            editAnotacao.setText(anotacao2);
        }

    }

}
