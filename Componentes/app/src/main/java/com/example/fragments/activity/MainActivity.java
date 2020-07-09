package com.example.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.fragments.R;
import com.example.fragments.fragment.ContatosFragment;
import com.example.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversas, buttonContatos;
    private FrameLayout frameConteudo;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Carregando IDs
        buttonConversas = findViewById(R.id.buttonConversas);
        buttonContatos = findViewById(R.id.buttonContatos);
        frameConteudo = findViewById(R.id.frameConteudo);

        //Remover a sombra da ActionBar
        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();
        contatosFragment = new ContatosFragment();

        //Configurando objeto para exibir os fragmentos
        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.frameConteudo, contatosFragment);
                transaction1.commit();

            }
        });

        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//ABRIUUUUU
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();//FECHOOOUUUU
            }
        });

    }
}
