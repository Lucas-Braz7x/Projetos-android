package com.example.componentes_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private TextInputEditText email;
    private TextView resultado;

    private CheckBox branco, verde, vermelho;

    private RadioButton masculino, feminino;
    private RadioGroup sexoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //User information
        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        resultado = findViewById(R.id.resultado);

        //Color information
        branco = findViewById(R.id.branco);
        verde= findViewById(R.id.verde);
        vermelho = findViewById(R.id.vermelho);

        //Radio button information
        masculino = findViewById(R.id.radioButtonM);
        feminino = findViewById(R.id.radioButtonFF);

        //Radio Group information
        sexoSelecionado = findViewById(R.id.radioGroup);

        radioButton();

    }

    public void checkBox(){
        String texto = "";
        if(branco.isChecked()){

            texto = branco.getText().toString() + " selecionado!\n";
        }
        if(verde.isChecked()){
            texto += verde.getText().toString() + " selecionado!\n";
        }
        if(vermelho.isChecked()){
            texto += vermelho.getText().toString() + " selecionado!\n";
        }

        resultado.setText(texto);
    }

    public void radioButton(){

    /*if(masculino.isChecked()){
        resultado.setText("Masculino");
    }
    else if(feminino.isChecked()){
        resultado.setText("Feminino");
    }*/

    sexoSelecionado.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.radioButtonM){
                resultado.setText("Masculino");
            }
            else if (checkedId == R.id.radioButtonFF){
                resultado.setText("Feminino");
            }

        }
    });



    }

    public  void enviar(View view){

    //    radioButton();

        //checkBox();

        /*String name = nome.getText().toString(); //Recupera o que foi digitado no campo e converte para string
        String yourEmail = email.getText().toString();


        resultado.setText("Resultado:\n" + name + "\n" + yourEmail);
        */
    }

    public void limpar(View view){

        nome.setText("");//Atualiza o campo
        email.setText("");
        resultado.setText("Resultado: \n Apagado");

    }
}
