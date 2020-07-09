package com.example.gasosaoualcul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText gasolina;
    private TextInputEditText alcool;
    private Button calcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolina = findViewById(R.id.gasolina);
        alcool = findViewById(R.id.alcool);
        calcular = findViewById(R.id.calcular);
        resultado = findViewById(R.id.resultado);
    }

    public void calculadora(View view){
        String precoAlcool = alcool.getText().toString();
        String precoGasolina = gasolina.getText().toString();

        //Validar preços
        Boolean result = this.validar(precoAlcool,precoGasolina);

        if(result){

            Double valorAlcool = Double.parseDouble(precoAlcool);//Converte uma String para Double
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double valor = valorGasolina/valorAlcool;

            if( valor >= 0.7 ){
                resultado.setText("Enche de alcool, irmão!");
            } else{
                resultado.setText("Gasosa na veia!");
            }

        }
        else{
            resultado.setText("Preencha todos os campos");
        }

    }

    public Boolean validar(String pAlcool, String pGasolina){

        Boolean camposValidados = true;
        String campo = "";
        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
            campo = "Alcool";
        }
        else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
            campo = "Gasolina";
        }

        return camposValidados;
    }


}
