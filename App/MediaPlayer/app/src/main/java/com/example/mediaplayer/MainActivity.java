package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay, buttonParar, buttonPause ;
    private SeekBar seekVolume;
    private AudioManager audioManager;

    //Classe media player permite manipular audios
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonParar = findViewById(R.id.buttonParar);
        buttonPause = findViewById(R.id.buttonPause);
        seekVolume = findViewById(R.id.seekVolume);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);

        iniciarSeekBar();

    }

    private void iniciarSeekBar(){

        //Configura o audio manager
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //Recuperando os valores de audio max e atual
        int volumeMax = audioManager.getStreamMaxVolume(audioManager.STREAM_MUSIC);

        int volumeAtual = audioManager.getStreamVolume(audioManager.STREAM_MUSIC);

        //Configurando o volume max do seekBar
        seekVolume.setMax(volumeMax);

        //configurando o volume atual da seekBar
        seekVolume.setProgress(volumeAtual);

        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void executarSom(View view){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public void pausarSom(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void pararSom(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        }
    }
}
