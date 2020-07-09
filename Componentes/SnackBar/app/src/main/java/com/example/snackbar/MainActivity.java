package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir;
    private  Button fechar;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbrir = findViewById(R.id.buttonAbrir);
        fechar = findViewById(R.id.fechar);

        buttonAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //É tipo um TOAST
                //Empurra o conteudo para cima
                snackbar = Snackbar.make(
                        view,//Define a tela a ser exibida
                        "Aew carai! apertou essa porra!", //define a mensagem
                        Snackbar.LENGTH_INDEFINITE // Define a duração
                ).setAction("ACEITAAAAA!", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonAbrir.setText("Alterou a porra toda");
                    }
                });

                snackbar.show();

            }
        });

        fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();//Encerra a snackbar
            }
        });


    }
}
