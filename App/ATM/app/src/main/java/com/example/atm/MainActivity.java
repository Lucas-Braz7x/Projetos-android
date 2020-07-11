package com.example.atm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public  void onClick(View view){

                enviarEmail();

            }

        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes, R.id.nav_contato, R.id.nav_servicos )
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        String celular = "tel: 24992119768";
        String imagem = "https://www.todoestudo.com.br/geografia/montanhas";
        String endereco = "https://www.google.com/maps/place/Pedra+do+Quitandinha/@-22.5330145,-43.2032637,15z/data=!4m8!1m2!2m1!1scastelinho+google+maps!3m4!1s0x99085148209503:0x9922dd50b7adbce2!8m2!3d-22.5274676!4d-43.2080913";

        //Intents defineações
        //Neste caso ela abre outro app (Ligações)
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));

        //Abre uma imagem e ou links
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lucasdutrabraz@gmail.com", "lucasbrazdutra@gmail.com", "luksafadinho@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo app");
        intent.putExtra(Intent.EXTRA_TEXT, "A coisa tá automática C-A-R-A-L-H-O!");

        //Outros tipos de arquivos em "mime types list"
        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "Compartilhar"));

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
