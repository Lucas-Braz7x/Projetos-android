package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private String[] itens = {
            "Vale do carangola", "Bairro da glória", "Alto da serra", "Independência",
            "Loteamento Samambaia", "Siméria", "Retiro", "Vicenzo Rivetti", "Bingen", "Itaipava"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);

        //Criar adaptador para lista
        //Define o tipo de itens que vai para a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        //Adicionando adaptador na lista
        lista.setAdapter( adaptador );

        //Adicionando clique na lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String valorSelecionado = lista.getItemAtPosition(position).toString();
                Toast.makeText(
                        getApplicationContext(), valorSelecionado, Toast.LENGTH_SHORT
                ).show();

            }
        });

    }



}
