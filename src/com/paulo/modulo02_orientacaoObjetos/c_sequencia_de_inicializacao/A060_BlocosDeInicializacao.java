package com.paulo.modulo02_orientacaoObjetos.c_sequencia_de_inicializacao;

import com.paulo.modulo02_orientacaoObjetos.c_sequencia_de_inicializacao.domain.AnimeComBlocoDeInicializacao;
import com.paulo.modulo02_orientacaoObjetos.c_sequencia_de_inicializacao.domain.AnimeSemBlocoDeInicializacao;

public class A060_BlocosDeInicializacao {
    public static void main(String[] args) {

        // Anime instanciado com atributos padrão inicializados.
        AnimeSemBlocoDeInicializacao shinge = new AnimeSemBlocoDeInicializacao();
        System.out.printf("Nome: %s, episódios: %d.\n",shinge.getNome(), shinge.getEpisodios());

        // Anime com atributos padrão ALTERADOS pelo construtor
        AnimeSemBlocoDeInicializacao naruto = new AnimeSemBlocoDeInicializacao("Naruto", 1000);
        System.out.printf("Nome: %s, episódios: %d.\n",naruto.getNome(), naruto.getEpisodios());

        System.out.println("----------------------------------------");

        AnimeComBlocoDeInicializacao shinge2 = new AnimeComBlocoDeInicializacao();
        System.out.printf("Nome atual: %s, %d.\n", shinge2.getNome(), shinge2.getEpisodios());
        System.out.println("----");

        AnimeComBlocoDeInicializacao bleach = new AnimeComBlocoDeInicializacao("Bleach", 366);
        System.out.printf("Nome atual: %s, %d.\n", bleach.getNome(), bleach.getEpisodios());
    }
}
