package com.example.aprendaingls.Fragment;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NomesFragment extends Fragment implements  View.OnClickListener {

    private ImageView imageCao, imageGato, imageLion, imageOvelha, imageVaca, imageMonkey ;
    private MediaPlayer mediaPlayer;

    public NomesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nomes, container, false);

        imageCao = view.findViewById(R.id.imageCao);
        imageGato = view.findViewById(R.id.imageGato);
        imageLion = view.findViewById(R.id.imageLion);
        imageMonkey = view.findViewById(R.id.imageMonkey);
        imageOvelha = view.findViewById(R.id.imageOvelha);
        imageVaca = view.findViewById(R.id.imageVaca);

        imageCao.setOnClickListener(this);
        imageGato.setOnClickListener(this);
        imageLion.setOnClickListener(this);
        imageMonkey.setOnClickListener(this);
        imageOvelha.setOnClickListener(this);
        imageVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imageCao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog );
                executarSom();
                break;

            case R.id.imageGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat );
                executarSom();
                break;

            case R.id.imageLion:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion );
                executarSom();
                break;

            case R.id.imageOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep );
                executarSom();
                break;

            case R.id.imageMonkey:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey );
                executarSom();
                break;

            case R.id.imageVaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow );
                executarSom();
                break;

        }
    }

    public void executarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();//Para esvaziar os recursos e audios do mediaPlayer
                }
            });
        }

    }
}
