package com.example.atm.ui.sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atm.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        //GetActivity pega o contexto da pagina
        // não é possivel apenas usar o "this" em um fragment
        View view = new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                //Para configurar o texto usar: .setDescription("")

                .addGroup("Entre em contato")
                .addEmail("lucasdutrabraz@gmail.com", "Envie um email")
                .addWebsite("www.google.com", "Acesse nosso site")

                .addGroup("Redes socias")
                .addFacebook("lucasbraz", "Facebook")
                .addInstagram("Tchubiross", "Instagram")
                .addTwitter("", "Twitter")
                .addYoutube("www.youtube.com.br", "Youtube")
                .addGitHub("Lucas-Braz7x", "Github")
                .addPlayStore("", "Download App")

                .addItem(versao)

                .create();

        return view;

        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }

}
