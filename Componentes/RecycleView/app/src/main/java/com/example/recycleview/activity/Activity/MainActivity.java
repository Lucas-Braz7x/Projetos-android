package com.example.recycleview.activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.recycleview.R;
import com.example.recycleview.activity.Adapter.Adapter;
import com.example.recycleview.activity.Model.Filme;
import com.example.recycleview.activity.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLista;
    //Listagem de filmes
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewLista = findViewById(R.id.recyclerViewLista);

        //Criando itens
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter(listaFilmes);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (getApplicationContext());
        recyclerViewLista.setLayoutManager(layoutManager);
        recyclerViewLista.setHasFixedSize(true);
        recyclerViewLista.setAdapter(adapter);

        //Adicionando evento de click
        recyclerViewLista.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerViewLista,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);

                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item pressionado: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);

                            Toast.makeText(
                                    getApplicationContext(),
                                    "Click longo: " + filme.getTituloFilme(),
                                    Toast.LENGTH_LONG
                            ).show();

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

    }


    public void criarFilmes(){
        Filme filme = new Filme("titulo", "genero"," ano");

        filme = new Filme("Amelí", "Romance"," 2002");
        this.listaFilmes.add(filme);

        filme = new Filme("Somos tão jovens", "Drama","2013");
        this.listaFilmes.add(filme);

        filme = new Filme("Logan", "Drama ficção","2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Como van gogh", "Drama"," 2018");
        this.listaFilmes.add(filme);

        filme = new Filme("V Guerra infinita", "Aventura ficção","2018");
        this.listaFilmes.add(filme);

        filme = new Filme("V Ultimato", "Aventura Ficção","2019");
        this.listaFilmes.add(filme);

        filme = new Filme("Batman Cavaleiro das Trevas", "Ficção","2009");
        this.listaFilmes.add(filme);

        filme = new Filme("Aranhaverso", "Ficção ","2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Van Helsing", "Aventura","2004");
        this.listaFilmes.add(filme);

        filme = new Filme("Clube dos 5", "Drama Comédia","1995");
        this.listaFilmes.add(filme);

        filme = new Filme("V de vingança", "Drama Ficção","????");
        this.listaFilmes.add(filme);

        filme = new Filme("Annabelle", "Terror","2014");
        this.listaFilmes.add(filme);

        filme = new Filme("Faroest Cabloco", "Drama","2014");
        this.listaFilmes.add(filme);

    }

}
