package com.example.aprendaingls.Fragment;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageUm, imageDois, imageTres, imageQuatro, imageCinco, imageSeis;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imageUm = view.findViewById(R.id.imageUm);
        imageDois = view.findViewById(R.id.imageDois);
        imageTres = view.findViewById(R.id.imageTres);
        imageQuatro = view.findViewById(R.id.imageQuatro);
        imageCinco = view.findViewById(R.id.imageCinco);
        imageSeis = view.findViewById(R.id.imageSeis);

        imageUm.setOnClickListener(this);
        imageDois.setOnClickListener(this);
        imageTres.setOnClickListener(this);
        imageQuatro.setOnClickListener(this);
        imageCinco.setOnClickListener(this);
        imageSeis.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        mediaPlayer = MediaPlayer.create(getActivity(),view.getId() );

        switch (view.getId()){
            case R.id.imageUm:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                excutandoSom();
                break;

            case R.id.imageDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                excutandoSom();
                break;

            case R.id.imageTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                excutandoSom();
                break;

            case R.id.imageQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                excutandoSom();
                break;

            case R.id.imageCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                excutandoSom();
                break;

            case R.id.imageSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                excutandoSom();
                break;
        }
    }

    public void excutandoSom(){
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
