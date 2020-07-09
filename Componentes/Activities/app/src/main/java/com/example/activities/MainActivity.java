package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.enviar);

        //Passando envento de click sem criar um método
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Mudando de activity (TELA)
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class );

                //Instanciando o objeto
                Usuario usuario = new Usuario("Tchubiro", "lucasdutrabraz@gmail.com");


                //Passando dados
                //Aceita qualquer tip de variavél
                intent.putExtra("nome", "Lucas");
                intent.putExtra("idade", 22);
                intent.putExtra("objeto", usuario);


                startActivity(intent);

            }
        });


    }

}
