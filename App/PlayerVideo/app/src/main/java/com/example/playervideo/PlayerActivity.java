package com.example.playervideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        //Esconder a statusBar e a barra de navegação
        View decorView = getWindow().getDecorView();//1 recupera um objeto de tela; 2 nos permite manipular componentes de tela

        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOpcoes);

        //Escondendo a actionBar
        getSupportActionBar().hide();

        //Executar video
        //Configura os controladores do video
        videoView.setMediaController(new MediaController(this));

        //Configura o caminho
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.start();

    }
}
