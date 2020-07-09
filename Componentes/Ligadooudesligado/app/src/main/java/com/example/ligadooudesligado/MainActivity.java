  package com.example.ligadooudesligado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

  public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButtonSenha;
    private Switch switchSenha;
    private TextView resultado;
    private CheckBox checkSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButtonSenha = findViewById(R.id.toggleButtonSenha);
        switchSenha = findViewById(R.id.switchSenha);
        resultado = findViewById(R.id.resultado);
        checkSenha = findViewById(R.id.checkSenha);

        adicionarOuvinte();
    }

    public void adicionarOuvinte(){//Procura alteações no app
        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    resultado.setText("Switch Ligado \n");
                }else{
                    resultado.setText("Switch Desligado \n");
                }
            }
        });
    }

    public void enviar(View view){

        /*if(switchSenha.isChecked()){
            resultado.setText("Ligado \n");
        }else{
            resultado.setText("Desligado \n");
        }

        if(toggleButtonSenha.isChecked()){
            resultado.setText("Ligadão");
        }else{
            resultado.setText("Desligadão");
        }*/
        if(checkSenha.isChecked()){
            resultado.setText("Marcado");
        }else{
            checkSenha.setText("Desmarcado");
        }
    }

}
