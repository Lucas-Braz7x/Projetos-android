package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText campoValor;
    private TextView percentGorjeta;
    private TextView valorGorjeta;
    private TextView valorTotal;
    private SeekBar seekBarPercent;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoValor = findViewById(R.id.campoValor);
        percentGorjeta = findViewById(R.id.percentGorjeta);
        valorGorjeta = findViewById(R.id.valorGorjeta);
        valorTotal = findViewById(R.id.valorTotal);
        seekBarPercent = findViewById(R.id.seekBarPercent);

        seekBarPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                percentGorjeta.setText(Math.round(porcentagem) + " %");

                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular()  {

        String valorRecuperado = campoValor.getText().toString();

        if(valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(),
                    "Digite um valor primeiro",
                    Toast.LENGTH_LONG).show();
        }else{

            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem/100);
            valorGorjeta.setText("R$ " + Math.round(gorjeta));

            double total = gorjeta + valorDigitado;
            valorTotal.setText("R$ " + total);
        }

    };

}
