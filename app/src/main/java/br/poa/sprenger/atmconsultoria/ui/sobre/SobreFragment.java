package br.poa.sprenger.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.poa.sprenger.atmconsultoria.R;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Element versao = new Element();
        versao.setTitle("Versão 07JUL20@19H12");
        //build.gradle (module: app) => implementation 'com.github.medyo:android-about-page:1.3'
        View aboutPage = new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription("A ATM consultoria tem como missão apoiar organizações que " +
                        "desejam alcançar o sucesso através da excelência em gestão e da busca " +
                        "pela qualidade.")
                .addGroup("Entre em contato")
                .addEmail("att@atmconsultoria.com.br", "att@atmconsultoria.com.br")
                .addWebsite("https://atmconsultoria.com.br", "Acesse nosso site")
                .addGroup("Redes sociais")
                .addFacebook("andersonsprenger", "fb.com/andersonsprenger")
                .addGitHub("knightencoder", "Github.com/knightencoder")
                .addItem(versao)
                .create();
        return aboutPage;
    }
}