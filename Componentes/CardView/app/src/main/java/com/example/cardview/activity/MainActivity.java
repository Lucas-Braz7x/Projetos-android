package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cardview.R;
import com.example.cardview.adapter.PostagemAdapter;
import com.example.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerView);

        //Definir layout
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);*/

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerPostagem.setLayoutManager(layoutManager);

        prepararPostagens();

        //Definindo adapter
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);

    }

    public void prepararPostagens(){
        Postagem p = new Postagem("Lucão", "Foda demais!", R.drawable.image2);
        this.postagens.add(p);

        p = new Postagem("Lucão", "Pika das galáxias!", R.drawable.image3);
        this.postagens.add(p);

        p = new Postagem("Lucão", "Meu deus do céu, fodaaaaa!", R.drawable.image4);
        this.postagens.add(p);

        p = new Postagem("Lucão", "Saudades dessa porra!", R.drawable.image1);
        this.postagens.add(p);

    }


}
