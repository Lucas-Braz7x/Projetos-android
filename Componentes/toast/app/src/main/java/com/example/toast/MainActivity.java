package com.example.toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarH, progressBarC ;
    private int progresso = 0;

    private SeekBar seekBarEscala;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarEscala = findViewById(R.id.seekBarEscala);
        textResultado = findViewById(R.id.textResultado);

        progressBarC = findViewById(R.id.progressBarC);
        progressBarH = findViewById(R.id.progressBarH);

        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textResultado.setText("Progresso " + progress + " / " + seekBar.getMax() );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Ocultando componente
        progressBarC.setVisibility(View.GONE);

    }

    public void recuperarProgresso(View view){

        textResultado.setText("Escolhido: " + seekBarEscala.getProgress());

    }


    public void carregar (View view){

        progressBarC.setVisibility(View.VISIBLE);

        this.progresso++;

        progressBarH.setProgress(this.progresso);

        if(this.progresso == 10){
            progressBarC.setVisibility(View.GONE);
        }

    }


    public void abrirToast(View view){

        ImageView image = new ImageView(getApplicationContext());
        image.setImageResource(android.R.drawable.star_big_off);

        TextView text = new TextView(getApplicationContext());
        text.setBackgroundResource(R.color.colorAccent);
        text.setText("É nois!");

        Toast  toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(text);
        toast.show();

        //Exibindo mensagens de alerta para o usuario
        /*Toast.makeText(getApplicationContext(),
                "Ação realizada com sucesso",
                Toast.LENGTH_LONG
        ).show();*/
    }


    public void alertDialog(View view){
        //Instanciando o alertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( this );

        //Configurando titulo e mensagem
        dialog.setTitle("Título da dialog");
        dialog.setMessage("Mensagem da dialog");

        //Configurar cancelamento
        dialog.setCancelable(false);

        //Configurar icone
        dialog.setIcon(android.R.drawable.alert_dark_frame);

        //Configurar ações
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        "Executar ação",
                        Toast.LENGTH_LONG).show();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        "Não executar ação",
                        Toast.LENGTH_LONG).show();
            }
        });

        dialog.create();
        dialog.show();

    }

}
